def count_words(sentence):
    words = sentence[:-1].split()
    return len(words)

stroka = "Это пример строки."
word_count = count_words(stroka)
print("Количество слов:", word_count) #вариант 8
