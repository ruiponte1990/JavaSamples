import java.util.Date;
import java.util.ArrayList;

/**
 * 
 * @author Rui Ponte
 *	The main difference between a part time and full time employee is the shifts they work.
 *	In order to tell the difference between the two Employees now have Schedules made up of Shifts.
 *	Shifts have two attributes, a double start, and a double end. For when the Employee starts and leaves work.
 *	Full time Employees work 9-5
 * 	A partTimeEmployee has the same attributes as a regular Employee, but their schedule has to be set when created.
 */

public class Employee {
	private boolean managerFlag; 
	private ArrayList<Shift> schedule;
	private String name;
	private Date dateHired;
	private int id;
	
	public class Shift{
		private double start;
		private double end;
		
		public Shift(double start, double end) {
			this.start = start;
			this.end = end;
		}
		public double getStart() {
			return start;
		}
		public double getEnd() {
			return end;
		}
	}
	
	public String getName() {
		return name;
	}
	public int getID() {
		return id;
	}
	public Date getDateHired() {
		return dateHired;
	}
	public boolean isManager() {
		return managerFlag;
	}
	
	public ArrayList<Shift> getSchedule(){
		return schedule;
	}
	public void setSchedule(ArrayList<Shift> schedule) {
		this.schedule = schedule;
	}
	
	public Employee(boolean managerFlag, String name, Date dateHired, int id) {
		this.managerFlag = managerFlag;
		this.name = name;
		this.dateHired = dateHired;
		this.id = id;
		Shift Monday = new Shift(9.0, 5.0);
		Shift Tuesday = new Shift(9.0, 5.0);
		Shift Wednesday = new Shift(9.0, 5.0);
		Shift Thursday = new Shift(9.0, 5.0);
		Shift Friday = new Shift(9.0, 5.0);
		this.schedule.add(Monday);
		this.schedule.add(Tuesday);
		this.schedule.add(Wednesday);
		this.schedule.add(Thursday);
		this.schedule.add(Friday);
	}
	
	public class partTimeEmployee extends Employee {
		public partTimeEmployee(boolean managerFlag, String name, Date dateHired, int id, ArrayList<Shift> schedule) {
			super(managerFlag, name, dateHired, id);
			setSchedule(schedule);
		}
		
	}

}
