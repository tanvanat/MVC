# Java MVC – Game & Room Selection Manager

This project is a **Java Swing application built using the MVC architecture**, designed to manage and track room selections across multiple games. Users can choose to assign rooms to games or remove rooms from those games depending on the mode they select.

The main goal of the project is to demonstrate **clean separation between Model, View, and Controller**, along with logical state management inside the Model.

---

## 🎯 Problem This Application Solves

Without a management system, assigning rooms to different games can get confusing — especially when:
- There are multiple games (Game1–Game5)
- Each game has multiple rooms (Room1–Room5)
- Each room can be chosen or released
- Users must follow specific constraints (e.g., limit of 3 chosen rooms)

This MVC application solves that problem by allowing users to:

### ✔ Select a *game* and automatically assign the next available room  
### ✔ Select a *room* and remove it from whichever game it was assigned to  
### ✔ Prevent over-selection (max 3 rooms chosen)  
### ✔ Ensure all state is tracked inside the Model, not the UI  

---

## 🧩 How It Works (Architecture Overview)

### 🟦 **Model**
- Stores all Games and Rooms (5 games × 5 rooms each)
- Tracks which rooms are “chosen”
- Business logic:
  - `calculategame(gameName)` → assigns a room to that game
  - `calculateroom(roomName)` → removes a chosen room from the correct game
- Ensures max selection limit (`chosenRooms <= 2`, which means max 3 rooms)

### 🟩 **View (Swing UI)**
- User interface with:
  - Radio buttons (Choose from Game / Choose from Room)
  - Input text field
  - Additional panel showing available items
  - Output area showing result
- Triggers callbacks based on user actions

### 🟧 **Controller**
- Reads user selection from View
- Calls Model methods
- Updates View with the result
- Handles invalid inputs

---
