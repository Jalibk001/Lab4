/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fairqueue;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
/**
 *
 * @author Jalib
 */
public class FairQueue {
         Queue head=null;
         Queue tail=null;
    
    public void readcsv() throws FileNotFoundException, IOException
    {
        String csvFile = "Academic _Schedule.csv";
         BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ","; 
        try {
            br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null) {
                Queue newnode=new Queue();
                String  []sch  = line.split(cvsSplitBy);
                
                        newnode.StartDate=sch[0];
                        newnode.EndDate=sch[1];
                        newnode.activity=sch[2];
                        if(head==null &&tail==null)
                {
                    
                    head=newnode;
                    tail=newnode;
                    head.next=null;
                    tail.next=null;
                }
                else
                {
                        newnode.StartDate=sch[0];
                    
                        newnode.EndDate=sch[1];
                    
                        newnode.activity=sch[2];
                    
                        }
                    Queue ptr;
                    ptr=head;
                    while (ptr.next!=null)
                    {
                        ptr=ptr.next;
                    }
                    if(ptr.next==null)
                    {
                        ptr.next=newnode;
                        tail=newnode;
                        newnode.next=null;
                    }
                }
            
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        } 
        finally {
            if (br != null) {
                try {
                    br.close();
                } 
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
                
            
        }            
        
    }
    Schedule sch;
    void setpri()
    {
        Queue ptr;
        ptr=head;
        while(ptr!=null){
            if(ptr.activity=="am"||ptr.activity=="pm")
            {    
                sch.priority=1;
                sch.facultyband=50;
                sch.stdband=50;
            }
            else if(ptr.activity=="Exam")
                sch.priority=2;
            ptr=ptr.next;
        }
    }
    public static void main(String[] args) throws IOException 
    {
        FairQueue a=new FairQueue();
        a.readcsv();
        String []slot=new String[4];
        slot[0]="12am-6pm";
        slot[1]="9am-3pm";
        slot[2]="3pm-9pm";
        slot[3]="12pm-6am";
    }
    
}
