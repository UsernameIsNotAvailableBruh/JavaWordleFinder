#Used to get the WordList
import requests

URL = "https://raw.githubusercontent.com/tabatkins/wordle-list/main/words"
Words = requests.get(URL)

with open("./WordList.txt", "wb") as f:
    f.write(Words.content)

with open("./WordList.txt", "r") as f:
    Lines = f.readlines()

Lines = sorted(list(set(Lines)))
print(f"There are {len(Lines)}.")
with open("./WordList.txt", "w") as f:
    f.write("".join(Lines))
