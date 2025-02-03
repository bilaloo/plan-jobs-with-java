package schedulingJobs;
import java.util.*;

class JobScheduler { 
    int start; 
    int end; 
    int length; 
  
    public JobScheduler(int start, int end) { 
        this.start = start; 
        this.end = end; 
        this.length = end - start; 
    }
}

public class Job {
    public static void findOptimalSchedule(JobScheduler[] jobs) { 
        Arrays.sort(jobs, Comparator.comparingInt(j -> j.end)); 
      
        int lastEndTime = 0; 
        List<JobScheduler> optimalSchedule = new ArrayList<>();
      
        for (JobScheduler job : jobs) { 
            if (job.start >= lastEndTime) { 
                optimalSchedule.add(job);
                lastEndTime = job.end;
            } 
        } 
      
        System.out.println("Optimaler Zeitplan:");
        for (JobScheduler job : optimalSchedule) {
            System.out.println("Job: Start = " + job.start + ", Ende = " + job.end);
        }
    }

    public static void main(String[] args) {
        JobScheduler[] jobs = {
            new JobScheduler(1, 3),
            new JobScheduler(2, 5),
            new JobScheduler(4, 6),
            new JobScheduler(6, 8),
            new JobScheduler(5, 7),
            new JobScheduler(8, 9)
        };
      
        findOptimalSchedule(jobs);
    }
}
