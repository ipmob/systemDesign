# Low Level Design (LLD)
The stock market analysis system can be divided into three main components:

1. Data Ingestion: This component will be responsible for ingesting the stock market data from various sources like CSV files, REST APIs, etc.The data ingestion component will be responsible for ingesting the stock market data from various sources like CSV files, REST APIs, etc. The component will receive the data and then parse and store it in the database for further processing.

2. 2.Data Storage: This component will store the ingested data in a database for quick and efficient access.The data storage component will store the ingested data in a database for quick and efficient access. The component will have the following attributes:
- `Ticker`: The name of the stock.
- `Price`: The price of the stock.
- `Time` : The time at which the stock price was recorded.

3. Data Analysis: This component will provide various functionalities for analyzing the stock market data like finding the highest and lowest prices of a stock within a certain time range, calculating the average stock price, etc.The data analysis component will provide various functionalities for analyzing the stock market data like finding the highest and lowest prices of a stock within a certain time range, calculating the average stock price, etc. For this, we will be using a range stack data structure that supports constant time range queries.


### Range Stack 
The range stack will be implemented using a doubly linked list with range search capabilities.
The range stack will have the following methods:

- `push`: Adds a new stock market data to the stack.
- `pop`: Removes the most recently added stock market data from the stack.
- `getMinInRange`: Returns the minimum stock price within a given time range.
- `getMaxInRange`: Returns the maximum stock price within a given time range.



The range stack will have the following attributes:

- `head/start`: A pointer to the head of the doubly linked list.
- `tail/end` : A pointer to the tail of the doubly linked list.
Constraints
The system should be able to handle a large volume of data.
The data ingestion component should be scalable and fault-tolerant.
The data storage component should be able to handle a large volume of data and support fast retrieval.
The data analysis component should support real-time data analysis and be able to handle a large volume of data.
The system should be able to handle concurrent requests efficiently.


  
### Design in OOO spectrum
To design a stock market analysis system that uses a range stack to analyze stock market data, we can start with the following object-oriented design:

Stock: This class represents a stock in the stock market. It contains attributes such as stock symbol, company name, current price, historical price data, etc. It also has methods to get and set these attributes.

Price: This class represents the price of a stock at a particular point in time. It contains attributes such as date, time, open price, close price, high price, low price, volume, etc. It also has methods to get and set these attributes.

PriceRangeStack: This class implements a stack that supports constant time range queries on a collection of Price objects. It contains methods to push a Price object onto the stack, pop a Price object from the stack, and get the highest and lowest prices within a specified time range.

StockMarketAnalysis: This class is the main class of the system. It contains a collection of Stock objects and uses PriceRangeStack to analyze the historical price data of each stock. It has methods to add and remove Stock objects from the collection, get the highest and lowest prices of a stock within a specified time range, and generate reports on stock performance.

With this object-oriented design, we can easily add new features to the system in the future, such as adding more types of financial instruments (e.g., bonds, futures, options), adding more analysis tools (e.g., moving averages, technical indicators), and integrating with external data sources (e.g., news feeds, social media sentiment analysis).
