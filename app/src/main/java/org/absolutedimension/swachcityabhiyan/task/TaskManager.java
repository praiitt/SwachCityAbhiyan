/*This class manage tasks and gives all the features which is attached with the task,for example,the prize money,
* task difficulties,team member size required to do so etc...*/
package org.absolutedimension.swachcityabhiyan.task;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import org.absolutedimension.swachcityabhiyan.R;

public class TaskManager extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_manager);
    }

    public void addPrizeMoneyToTask(){
        //this method will add Prize to the task.
    }

    public boolean isAllocated(){
       //this method returns whether a task is allocated to volunteer or not.
        return true;
    }

    public void mapUserWithTask(){

    }

    public int returnTotalNoOfTask(){
       //this method gives the  total number of task registered.
        return  1;
    }

    public void addBidButtonToTask(){

    }
}
