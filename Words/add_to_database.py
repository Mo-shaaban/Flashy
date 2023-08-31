import psycopg2

# Database connection parameters
db_params = {
    'dbname': 'testdb',
    'host': 'localhost',
    'port': 5432
}

# Words data in the specified format
words_data = []
file = open("B1_database_sample.txt", "r")
for line in file.readlines():
    if line.strip():
        german_word, english_word = line.split(' - ')
        words_data.append((german_word, english_word))


# Connect to the database
try:
    connection = psycopg2.connect(**db_params)
    cursor = connection.cursor()

    # Insert words into the table
    for german_word, english_word in words_data:
        insert_query = "INSERT INTO words (englishWord, germanWord, level) VALUES (%s, %s, %s)"
        cursor.execute(insert_query, (english_word, german_word, 'B1'))

    # Commit the changes
    connection.commit()
    print("Words added successfully!")

except (Exception, psycopg2.Error) as error:
    print("Error while connecting to PostgreSQL:", error)

finally:
    # Close the cursor and connection
    if connection:
        cursor.close()
        connection.close()
        print("Database connection closed.")
