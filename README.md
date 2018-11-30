# JavaSamples
Some basic Java code I wrote for a job application


Employee.java : Extending a class and adding functionality

UserKey.java, UserKeyTests.java, TestSuite.java and TestRunner.java: Creating a Serializable object and testing it's functionality in Junit

xml_Parse.java, xml_Tree.java: Recursive text parser that ensures xml documents are well formed and correct

i.e: 

<BackgroundCheck>
  <CriminalHistory>
    <HistoryCode>x</HistoryCode>
    < HistoryCode>y</HistoryCode>
    < HistoryCode>z</HistoryCode>
  </CriminalHistory>
</BackgroundCheck>

vs:

<BackgroundCheck>
  <CriminalHistory>
    <Fail>
    <HistoryCode>x</HistoryCode>
    < HistoryCode>y</HistoryCode>
    < HistoryCode>z</HistoryCode>
  </CriminalHistory>
</BackgroundCheck>
