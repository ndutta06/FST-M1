# users names
user1 = input("Enter Player 1's name? ")
user2 = input("Enter Player 2's name? ")

# users choices
user1_ans = input(user1 + ", do you want to choose rock, paper or scissors? ").lower()
user2_ans = input(user2 + ", do you want to choose rock, paper or scissors? ").lower()

# Run the algorithm to see who wins
if user1_ans == user2_ans:
    print("It's a tie!")
elif user1_ans == 'rock':
    if user2_ans == 'scissors':
        print("Rock wins!")
    else:
        print("Paper wins!")
elif user1_ans == 'scissors':
    if user2_ans == 'paper':
        print("Scissors win!")
    else:
        print("Rock wins!")
elif user1_ans == 'paper':
    if user2_ans == 'rock':
        print("Paper wins!")
    else:
        print("Scissors win!")
else:
    print("Invalid input! You have not entered rock, paper or scissors, try again.")