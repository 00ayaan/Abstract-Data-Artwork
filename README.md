# Project: New Scene, New Me

## Introduction

Software engineers develop programs to create visual and audio experiences using object-oriented programming. As we begin 2026, your goal is to create an animation program that reflects on your experiences from 2025 and visualizes your goals and aspirations for the year ahead using the Theater and Scene API.

## Requirements

Use your knowledge of object-oriented programming, one-dimensional (1D) arrays, algorithms, and the Theater/Scene API to create your animation program:
- **Write Scene subclasses** – Create two Scene subclasses: one to visualize your 2025 recap (LastYear) and another to project your 2026 goals (ThisYear). Each class must include both a no-argument constructor and a parameterized constructor.
- **Use private instance variables** – Implement proper encapsulation by declaring instance variables as private in your Scene subclasses.
- **Create 1D arrays** – Create at least two 1D arrays to store data for your scenes. One array must be created using an initializer list, and one array must be populated by reading from a text file using the FileReader class.
- **Write a method** – Write a method that finds or manipulates the elements in a 1D array to provide the information your user needs.
- **Access and modify array elements** – Use algorithms to traverse, access, and/or modify elements in your 1D arrays to display personalized content in your scenes.
- **Use logic and iteration** – Incorporate selection statements (if/if-else) and loops (while, for, or enhanced for) to control the flow and display of content in your scenes.
Incorporate variety of media – Use at least four different types of Scene API methods across both scenes (examples: drawImage(), drawText(), drawRectangle(), drawEllipse(), playSound(), setTextStyle(), setFillColor(), etc.).
- **Create a UML diagram** – Design a UML class diagram showing your Scene subclasses with their instance variables, constructors, and methods before you begin coding.
- **Document your code** – Use multi-line comments to explain the purpose of each method (including preconditions and postconditions) and single-line comments to explain code segments.

## UML Diagram 

![UML Diagram for my project](uml.png) 

## Description of 2025 recap

In my 2025 recap I included a number of catagories that made up my new year; these include memories, my friends, and the music I listened to. I started off by including a photo stack of my memories or cool places I visited this year like concerts and vacations. I then shifted to a similar format with photos of my friends that I took this year. I finally shifted to a grid pattern of 16 albums that made my year and music from each album would play when one would show up.

## Description of 2026 goals

In my 2026 recap I included some of the few photos that I took this year in a stacked format. To end off the slideshow, I created an ending screen with some text. 
## Scene API Usage

I was able to use certain tools in the Scene API to enhance my theather experience. Some examples of this was using the playSound() method that allows me to add a dimension to my music section of my 2025 recap. Another example is the drawText() method to add captions and titles to the parts of my slideshow.
