import os
import openai
import numpy as np
import pandas as pd
import matplotlib.pyplot as plt
import seaborn as sns
import datetime
import threading

client = openai.OpenAI()  # Replace with your API key and parameters
lock = threading.Lock()  # Global lock for shared data access

def output_threaded(prompt):
    global lock  # Ensure lock is accessible within the thread function

    with lock:  # Acquire lock before accessing shared data
        response = client.chat.completions.create(...)
    return response.choices[0].message.content

def process_row(row_id, df_row):
    sentiment = output_threaded(df_row['content'])
    with lock:  # Acquire lock before updating shared data
        df.loc[row_id, 'sentiment'] = sentiment

def main():
    df = pd.read_csv('final1.csv')

    # Use a thread pool or other suitable strategy for multithreading
    threads = []
    for row_id in df.index:
        thread = threading.Thread(target=process_row, args=(row_id, df.loc[row_id]))
        thread.start()
        threads.append(thread)

    # Wait for all threads to finish
    for thread in threads:
        thread.join()

    print(df)  # Access the updated DataFrame

if __name__ == '__main__':
    main()
