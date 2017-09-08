# CCI Chapter 1 Problem 2
# Algorithm to see if the left string is a permutation of the right string

char_dictionary = {}
left = input("Input the first string to see if it a permutation of the next string: ")
right = input("Input the second string: ")

perm = 0

def find_perm_left(left, right):
    # Success condition, if all values of left have been checked then return true
    if len(left) == 0:
        return 1
    
    test_char = left[0]

    # Search for the test_char in the right string
    for c in right:
        if c == test_char:
            # Instead of intelligently  removing the found character from the right sting, replace it with a tilde
            # TODO replace with a function
            c = '~'
            # Where the fun stuff happens, recursive call and remove the found character from the left & right string (see above)
            return find_perm_left(all_but_first_char(left), right)

    return 0


def all_but_first_char(str):
    new_str = ""

    for x in range(1, len(str)):
        new_str += str[x]

    return new_str

if len(left) == len(right):
    result = find_perm_left(left, right)

else:
    result = 0


if result:
    print("The first string is a permutation of the second string")
else:
    print("The first string is not a permutation of the second string")