# importing required modules
from PyPDF2 import PdfReader
import re
import enchant

def has_numbers(inputString):
    return bool(re.search(r'\d', inputString))
# creating a pdf reader object
reader = PdfReader('B1-Glossary.pdf')
  
# printing number of pages in pdf file
# print(len(reader.pages))
  
# getting a specific page from the pdf file
file = open("B1-words", "w")
for i in range(3, 49):
        page = reader.pages[i]
        # extracting text from page
        text = page.extract_text()
        for line in text.split('\n'):
                if len(line.split()) == 0:
                        pass
                elif line.split()[0] == "Kapitel":
                        pass
                #     elif has_numbers(line.split()[0]):
                #         pass
                else: 
                        print (line, file=file)