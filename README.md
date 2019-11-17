# JavaSamples
Some basic Java code I wrote for a job application


Employee.java : Extending a class and adding functionality

UserKey.java, UserKeyTests.java, TestSuite.java and TestRunner.java: Creating a Serializable object and testing it's functionality in Junit

xml_Parse.java, xml_Tree.java: Recursive text parser that ensures xml documents are well formed and correct

i.e: 
<!-->
			<BackgroundCheck>
  				<CriminalHistory>
    				<HistoryCode>x</HistoryCode>
    				<HistoryCode>y</HistoryCode>
    				<HistoryCode>z</HistoryCode>
  				</CriminalHistory>
			</BackgroundCheck>
<!-->
vs:

<!-->
			<BackgroundCheck>
  				<CriminalHistory>
    			<Fail>
    				<HistoryCode>x</HistoryCode>
    				<HistoryCode>y</HistoryCode>
    				<HistoryCode>z</HistoryCode>
  				</CriminalHistory>
			</BackgroundCheck>
<!-->

Game, Game_select, Game_tree, etc... were for another job interview question:

Adam is so good at playing arcade games that he will win at every game he plays. One fine day as he was walking on the street, he discovers an arcade store that pays real cash for every game that the player wins - however, the store will only pay out once per game. The store has 10 games for which they will pay winners, and each game has its own completion time and payout rate. Thrilled at the prospect of earning money for his talent, Adam walked into the store only to realize that the store closes in 2 hours (exactly 120 minutes). Knowing that he cannot play all the games in that time, he decides to pick the games that maximize his earnings

Write code (or pseudocode) in your favorite programming language to help Adam pick the sequence(s) of games that earn him the most money?.  Then, assume you have a variable list of games and their payout rates. What is the best way to pick the games that earn you the most?

An acceptable solution is a workable solution that accounts for all the different scenarios in a variable list of games with their completion times and payout rates.
