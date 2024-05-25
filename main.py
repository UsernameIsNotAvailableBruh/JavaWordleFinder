import requests

URL = "https://raw.githubusercontent.com/tabatkins/wordle-list/main/words"
URL2 = "https://raw.githubusercontent.com/simonlsc/wordleWordList/main/wordleWordList.txt"

#using two to make sure none are missed

Words = requests.get(URL)
Words2 = requests.get(URL2)

with open("WordList.txt", "wb") as f:
    f.write(Words.content)
    f.write(b"\n")
    f.write(Words2.content)

with open("WordList.txt", "r") as f:
    Lines = f.readlines()

print(len(Lines))
Lines = sorted(list(set(Lines)))
print(len(Lines))
with open("WordList.txt", "w") as f:
    f.write("".join(Lines))
