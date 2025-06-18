# Database MCP Server

A Java Spring-based Model Context Protocol (MCP) server that provides seamless database access and querying capabilities through MCP tools. This server enables AI assistants and other MCP clients to interact with your database using structured parameters and queries.

## Overview

This project implements an MCP server using Java Spring Boot that acts as a bridge between MCP clients (like Claude Desktop) and your database. The server exposes database operations as MCP tools, allowing clients to:

- Fetch data from database tables with flexible parameter filtering
- Execute structured queries with multiple input parameters
- Access database functionality through a standardized MCP interface
- Maintain secure database connections with configurable parameters

The MCP (Model Context Protocol) enables AI assistants to access external tools and resources in a standardized way. This server specifically focuses on database operations, making it easy for AI assistants to query and retrieve data from your database tables based on dynamic parameters.


## Prerequisites

- Java 17 or higher
- Maven 3.6 or higher
- A supported database system (MySQL, PostgreSQL, etc.)
- Claude Desktop or another MCP client (for testing and usage)

## Installation

### 1. Clone the Repository

```bash
git clone https://github.com/mrunal-Shah7/AdaniDb-mcp.git
cd AdaniDB-mcp
```

### 2. Database Setup

#### Configure Database Connection
Edit the database connection parameters in the `application.properties` file located at:
```
src/main/resources/application.properties
```

Update the following properties with your database details:
```properties
# Database Configuration
spring.datasource.url=jdbc:mysql://localhost:3306/your_database_name
spring.datasource.username=your_username
spring.datasource.password=your_password
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

# JPA Configuration
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect
```

#### Create Database Tables(The given sql file will work only for MySQL innoDB engine)
Use the SQL file located in the root folder to create the necessary tables:
```bash
mysql -u your_username -p your_database_name < database_schema.sql
```

### 3. Build the Project

Build the JAR file using Maven:
```bash
mvn clean package
```

The compiled JAR file will be located in the `target/` directory.

### 4. Configure MCP Client

If you're using Claude Desktop as your MCP client, edit your `claude_desktop_config.json` file:

**Location of config file:**
- **macOS**: `~/Library/Application Support/Claude/claude_desktop_config.json`
- **Windows**: `%APPDATA%\Claude\claude_desktop_config.json`

**Configuration:**
```json
{
  "mcpServers": {
    "adaniDB-mcp": {
      "command": "java",
      "args": [
        "-jar",
        "/path/to/your/project/target/your-jar-file-name.jar"
      ],
      "env": {}
    }
  }
}
```

Replace `/path/to/your/project/target/your-jar-file-name.jar` with the actual path to your built JAR file.

## Usage

### Starting the Server

The MCP server will start automatically when Claude Desktop launches and detects the configuration. 

### Available MCP Tools

Once configured, the server exposes database operations as MCP tools. The specific tools available depend on your implementation, but typically include:

- **Query Tools**: Execute parameterized queries against your database tables
- **Data Retrieval Tools**: Fetch data with filtering and sorting capabilities
- **Schema Tools**: Access table structure and metadata information

- Designed for integration with Claude Desktop and other MCP clients
