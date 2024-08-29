import xml.etree.ElementTree as ET
import json

# Sample XML data
xml_file = open("books.xml")
xml_data = xml_file.read()

# Parse the XML data
root = ET.fromstring(xml_data)

# Convert XML to dictionary
library = {"library": {"book": []}}

for book in root.findall('book'):
    book_data = {
        "title": book.find('title').text,
        "author": book.find('author').text,
        "year": book.find('year').text
    }
    library["library"]["book"].append(book_data)

# Convert dictionary to JSON
json_data = json.dumps(library, indent=4)

# Print JSON data
print(json_data)
