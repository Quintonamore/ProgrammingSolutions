# CCI Chapter 1 Problem 4
# Pallindrome permutation, checks to see if the two given strings are the same forwards and backwards.

# Value to count the only odd pairing available
odd_pairing = 0

def find_other_letter(str):

    first_char = str[0]

    char_cntr = 1

    for i in range(1, len(str)):
        if str[i] == first_char:
            char_cntr += 1

    str = str.replace(first_char, '')

    if char_cntr % 2:
        return 0
    elif len(str):
        find_other_letter(str)
    elif :
        return 1

word = input("Input the string to be tested")

if find_other_letter(word):
    print(word + " is a palindrome permutation")
else:
    print(word + " is not a palindrome permutation")