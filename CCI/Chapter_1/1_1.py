# CCI Chapter 1 Problem 1
# Workable solution using python's dictionary data structure

alphabet_list = {}
test_string = input("Enter the string to be tested for unique characters: ")

all_unique_chars = 1

# Loop to run through and add all of the characters in the string to the dictionary
for character in test_string:
    # If the character isn't in the dictionary, then add it
    if not character in alphabet_list:
        alphabet_list[character] = 1

    # If the character is found, then there are duplicate characters, exit the loop
    else:
        all_unique_chars = 0
        break

# Report the result
if all_unique_chars:
    print("Nice, no duplicate characters")

else:
    print("There were duplicate characters")