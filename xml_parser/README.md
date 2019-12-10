Recursive text parser that ensures xml documents are well formed and correct

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
