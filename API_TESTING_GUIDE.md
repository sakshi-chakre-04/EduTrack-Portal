# MarvellousFullStack API Testing Guide

## Prerequisites
1. **MongoDB** should be running on `localhost:27017`
2. **Spring Boot Application** should be running on `http://localhost:8080`
3. **Postman** installed (or any API testing tool)

## How to Use the Postman Collection

### 1. Import the Collection
1. Open Postman
2. Click on "Import" button
3. Select the `MarvellousFullStack_API.postman_collection.json` file
4. The collection will be imported with 4 ready-to-use requests

### 2. API Endpoints Testing

#### Step 1: Get All Batches
- **Request**: `GET http://localhost:8080/batches`
- **Purpose**: Check existing batches and get their IDs
- **Expected Response**: Array of batch objects or 404 if empty

#### Step 2: Create New Batch
- **Request**: `POST http://localhost:8080/batches`
- **Body**: 
```json
{
    "name": "Java Full Stack",
    "fees": 25000
}
```
- **Expected Response**: Created batch object with 201 status

#### Step 3: Update Batch
- **Request**: `PUT http://localhost:8080/batches/id/{{batchId}}`
- **Important**: Replace `{{batchId}}` with actual MongoDB ObjectId from Step 1 response
- **Body**:
```json
{
    "name": "Python Full Stack Updated",
    "fees": 30000
}
```
- **Expected Response**: Updated batch object with 200 status

#### Step 4: Delete Batch
- **Request**: `DELETE http://localhost:8080/batches/id/{{batchId}}`
- **Important**: Replace `{{batchId}}` with actual MongoDB ObjectId
- **Expected Response**: 204 No Content status

### 3. Sample MongoDB ObjectId Format
MongoDB ObjectIds look like: `65d8a1b2c3d4e5f6a7b8c9d0`
Use the actual IDs from your GET responses for update/delete operations.

### 4. Common Response Codes
- **200 OK**: Successful GET/PUT request
- **201 Created**: Successful POST request
- **204 No Content**: Successful DELETE request
- **400 Bad Request**: Invalid request body
- **404 Not Found**: Resource not found
- **500 Internal Server Error**: Server error

### 5. Testing Workflow
1. Start with `GET All Batches` to see existing data
2. Use `POST Create Batch` to add new entries
3. Copy the `_id` from the response for update/delete operations
4. Test `PUT Update Batch` with the copied ID
5. Test `DELETE Batch` with the same ID
6. Verify deletion with `GET All Batches` again

### 6. Environment Variables
The collection includes a variable `{{batchId}}` that you can:
- Set manually in Postman environment
- Update automatically from API responses
- Replace directly in the URL for testing

## Database Configuration
The application connects to MongoDB at: `mongodb://localhost:27017/MarvellousFullStackX`
Collection name: `BatchDetails`

## Running the Application
```bash
mvn spring-boot:run
```
The server will start on `http://localhost:8080`
