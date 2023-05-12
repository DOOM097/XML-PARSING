import xml.etree.ElementTree as ET

# Путь к файлу XML
file_path = "news.xml"

# Создание объекта ElementTree и чтение XML файла
tree = ET.parse(file_path)
root = tree.getroot()

# Проход по каждому элементу <item> в XML и извлечение данных
for item in root.findall("./channel/item"):
    # Извлечение данных из элементов
    title = item.find("title").text
    description = item.find("description").text
    pub_date = item.find("pubDate").text
    author = item.find("author").text
    category = item.find("category").text

    # Вывод данных
    print("Title:", title)
    print("Description:", description)
    print("Publication Date:", pub_date)
    print("Author:", author)
    print("Category:", category)
    print()