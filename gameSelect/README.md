Adam is so good at playing arcade games that he will win at every game he plays. One fine day as he was walking on the street, he discovers an arcade store that pays real cash for every game that the player wins - however, the store will only pay out once per game. The store has 10 games for which they will pay winners, and each game has its own completion time and payout rate. Thrilled at the prospect of earning money for his talent, Adam walked into the store only to realize that the store closes in 2 hours (exactly 120 minutes). Knowing that he cannot play all the games in that time, he decides to pick the games that maximize his earnings

Write code (or pseudocode) in your favorite programming language to help Adam pick the sequence(s) of games that earn him the most money?.  Then, assume you have a variable list of games and their payout rates. What is the best way to pick the games that earn you the most?

An acceptable solution is a workable solution that accounts for all the different scenarios in a variable list of games with their completion times and payout rates.

There are two solutions to this problem in this repo. I originally visualized this problem like a choose your own adventure book. I thought it would be intuitive to write all the branching paths as tree and then just traverse it. This code is in the game_tree folder. 

Later someone told me this was actually the bin packing problem (I had never heard of it). The canonical solution using dynamic programming is in the game_select_bin_packing folder. 