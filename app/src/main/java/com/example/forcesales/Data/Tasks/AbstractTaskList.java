package com.example.forcesales.Data.Tasks;
/*
 * 												TaskList Class
 *
 * This class handles storing all the task objects into a list. As well as functions which allow the returning of
 * tasks that are complete, not complete, or assigned to a specific employee.
 *
 * Attributes:
 * compare_tasks - CompareTwoObjects<Task,Boolean>: Does a comparison to see if isTaskDone() equals the boolean value.
 * compare_date - CompareTwoObjects<Task,Calendar>: Does a comparison check to see if the Day, Month, and Year equals the same.
 * 
 * Functions (You can also use functions from the ArrayList class):
 * void - getCompletedTasks() - Returns a list of all completed tasks.
 * void - getTasks() - Returns a list of all Tasks that have not been completed.
 * void - getTodaysTasks() - Returns a list of tasks that are due on the date that this function is called.
 */

import android.os.Parcel;
import android.os.Parcelable;

import com.example.forcesales.Data.Person.Person;
import com.example.forcesales.Data.util.AbstractArrayListComparsion;
import com.example.forcesales.Data.util.CompareTwoObjects;

import java.util.Calendar;

abstract public class AbstractTaskList<A extends AbstractTask<?>, B extends AbstractTaskList<A,B>> extends AbstractArrayListComparsion<A,B> {


    // Attributes
    private CompareTwoObjects<A,Boolean> compare_tasks = (a, b) -> a.isTaskDone() == b;
	  private CompareTwoObjects<A, Calendar> compare_date = (a, b) -> {
	    Calendar a2 = a.getCalendarDueDate();
        return a2.get(Calendar.DAY_OF_MONTH) == b.get(Calendar.DAY_OF_MONTH)
                && a2.get(Calendar.MONTH) == b.get(Calendar.MONTH)
                && a2.get(Calendar.YEAR) == b.get(Calendar.YEAR);
    };

	//Constructor
	protected AbstractTaskList(){
		super();
	}

	public B getCompletedTasks() {
	   return abstractContains(true, compare_tasks);
	}

	public B getTasks() {
	   return abstractContains(false, compare_tasks);
	}

	public B getTodaysTasks() {
		return abstractContains(Calendar.getInstance(), compare_date).getTasks();
	}


//	//parcelable methods
//	@Override
//	public int describeContents() {
//		return 0;
//	}
//
//	@Override
//	public void writeToParcel(Parcel dest, int flags){
//		dest.writeList(this);
//	}
//
//	//creator
//	public static final Creator CREATOR = new Creator() {
//		public AbstractTaskList createFromParcel(Parcel in){
//			return new AbstractTaskList(in);
//		}
//
//		public AbstractTaskList[] newArray(int size){
//			return new AbstractTaskList[size];
//		}
//	};
//
//	//de-parecel object
//	private AbstractTaskList(Parcel in) {
//		in.readList(this, Task.class.getClassLoader());
//	}
}

