import requests
import tkinter as tk
from tkinter import messagebox
from tkinter import filedialog

def get_repo_info():
    # Получаем введенное имя репозитория
    repo_name = repo_input.get()
    if not repo_name:
        messagebox.showerror("Ошибка", "Введите имя репозитория!")
        return

    api_url = f"https://api.github.com/repos/{repo_name}"
    try:
        response = requests.get(api_url)
        if response.status_code != 200:
            messagebox.showerror("Ошибка", f"Не удалось получить данные. Код ошибки: {response.status_code}")
            return

        repo_data = response.json()
        
        # Извлекаем нужные поля
        extracted_data = {
            'company': repo_data.get('owner', {}).get('company'),
            'created_at': repo_data.get('created_at'),
            'email': repo_data.get('owner', {}).get('email'),
            'id': repo_data.get('owner', {}).get('id'),
            'name': repo_data.get('owner', {}).get('login'),
            'url': repo_data.get('owner', {}).get('url'),
        }

        # Сохраняем результат в файл
        save_path = filedialog.asksaveasfilename(defaultextension=".json", filetypes=[("JSON files", "*.json")])
        if save_path:
            with open(save_path, "w") as file:
                import json
                json.dump(extracted_data, file, indent=4)
            messagebox.showinfo("Успех", f"Данные сохранены в файл: {save_path}")

    except Exception as e:
        messagebox.showerror("Ошибка", f"Произошла ошибка: {e}")

# Настройка интерфейса
root = tk.Tk()
root.title("GitHub Repo Info Fetcher")

tk.Label(root, text="Введите имя репозитория (например, ansible/ansible):").pack(pady=5)
repo_input = tk.Entry(root, width=50)
repo_input.pack(pady=5)

tk.Button(root, text="Получить информацию", command=get_repo_info).pack(pady=10)

root.mainloop()
