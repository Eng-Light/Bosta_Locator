# Bosta Locator 🚚

An Android task project built for Bosta using a clean MVVM architecture. This app displays a list of cities and their districts fetched from a remote API.

## 📱 Features & Technologies
- Fetches and displays cities with their corresponding districts
- Follows MVVM design pattern
- Network error handling
- Loading states and empty states handling
- Search functionality for cities and districts
- Uses domain-driven principles with a clean architecture
- Dependency Injection using Dagger 2
- Coroutines for async data fetching
- Jetpack components: ViewModel, Fragment, RecyclerView, Navigation
- Two-way binding using databinding

## Screenshots
<div align="center">
<img src="https://github.com/user-attachments/assets/cdf7b57a-8fbe-44d2-9411-db2e4e1e2507" alt="Screenshot 1" width="200" style="border: 5px solid #ccc; border-radius: 15px;">
<img src="https://github.com/user-attachments/assets/59fc40ff-d908-44a1-a4f2-d3983bd970fa" alt="Screenshot 2" width="200" style="border: 5px solid #ccc; border-radius: 15px;">
<img src="https://github.com/user-attachments/assets/7a0d4def-9686-4ab3-84a1-9f142638b70c" alt="Screenshot 3" width="200" style="border: 5px solid #ccc; border-radius: 15px;">
<img src="https://github.com/user-attachments/assets/f6c3c5d0-77f0-41a0-9def-c2aaf73c9494" alt="Screenshot 3" width="200" style="border: 5px solid #ccc; border-radius: 15px;">
<img src="https://github.com/user-attachments/assets/f37c7ac7-1c8f-44f9-8f70-35c63b405b63" alt="Screenshot 3" width="200" style="border: 5px solid #ccc; border-radius: 15px;">
<img src="https://github.com/user-attachments/assets/f63f58b2-8298-485d-9c14-3c22716e9d2a" alt="Screenshot 3" width="200" style="border: 5px solid #ccc; border-radius: 15px;">
</div>

## 🧱 Architecture Overview
The app follows a clean architecture approach with these main packages:

* Data - Contains data layer components
  - repository - Implementation of repositories
  - datasource - Data sources (remote)
  - mapper - Data mappers between layers
  - model - Data transfer objects
  - network - API service and configurations
* Domain - Contains business logic
  - model - Domain models
  - repository - Repository interfaces
  - usecase - Business use cases
* UI - Contains presentation layer
  - base - Base classes for adapters and utilities
  - choosedeliveryarea - Main screen components
  - common - Shared components
  - utils - Utility classes and binding adapters
