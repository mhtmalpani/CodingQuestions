# Coding Questions

### [Array Element Multiplication](https://github.com/mhtmalpani/CodingQuestions/blob/master/src/ArrayElementMultiplication.kt)

Given an array of integers, return a new array such that each element at index i of the new array is the product of all the numbers in the original array except the one at i.

For example, if our input was [1, 2, 3, 4, 5], the expected output would be [120, 60, 40, 30, 24]. If our input was [3, 2, 1], the expected output would be [2, 3, 6]

Follow-up: what if you can't use division?

---

### [Decoding Ways](https://github.com/mhtmalpani/CodingQuestions/blob/master/src/DecodingWays.kt)

Given the mapping a = 1, b = 2, ... z = 26, and an encoded message, count the number of ways it can be decoded.

For example, the message '111' would give 3, since it could be decoded as 'aaa', 'ka', and 'ak'.

You can assume that the messages are decodable. For example, '001' is not allowed.

---

### [Staircase](https://github.com/mhtmalpani/CodingQuestions/blob/master/src/Staircase.kt)

There exists a staircase with N steps, and you can climb up either 1 or 2 steps at a time. Given N, write a function that returns the number of unique ways you can climb the staircase. The order of the steps matters.

For example, if N is 4, then there are 5 unique ways:

1, 1, 1, 1

2, 1, 1

1, 2, 1

1, 1, 2

2, 2

What if, instead of being able to climb 1 or 2 steps at a time, you could climb any number from a set of positive integers X? For example, if X = {1, 3, 5}, you could climb 1, 3, or 5 steps at a time.

---

### [Criss Cross Numbers](https://github.com/mhtmalpani/CodingQuestions/blob/master/src/CrissCrossNumbers.kt)

Given a list of numbers:
Make a new list that follows the conditions:
a. Every odd index value must be smaller than all previous elements
b. Every even index value must be greater than all previous elements

Note: The numbers can repeat itself

Sample Data:

Input:  
5, 2, 30, 4, 12, 9, 1, 7, 25

Output:
 
7, 5, 9, 4, 12, 2, 25, 1, 30

---

### [K Uniques Substrings](https://github.com/mhtmalpani/CodingQuestions/blob/master/src/KUniquesSubstring.kt)

Given an integer k and a string s, find the length of the longest substring that contains at most k distinct characters.

For example, given s = "abcba" and k = 2, the longest substring with k distinct characters is "bcb".

---

### [Word Wrap](https://github.com/mhtmalpani/CodingQuestions/blob/master/src/WordWrap.kt)

Implement a function to wrap a string of arbitrary length with new line character based on max characters allowed in each line.

---

### [Travelling People](https://github.com/mhtmalpani/CodingQuestions/blob/master/src/TravellingPeople.kt)

Given a ArrayList of tuples:
Pair(A, B)

This value indicates cost of transportation for a person to travel to

A -> City A

B -> City B

Find out the equal distribution of people so that the overall transportation cost can be minimised
Priority is to get people with lesser cost to City A because of budget issues.

---

### [Merge Sorted Arrays](https://github.com/mhtmalpani/CodingQuestions/blob/master/src/MergeSortedArrays.kt)

Given 2 Sorted arrays, compute a merged sorted array.

Sample Input:

Array A ->
         1, 3, 5, 7
         
Array B ->
         2, 4, 6

Output:
         1, 2, 3, 4, 5, 6, 7

---
