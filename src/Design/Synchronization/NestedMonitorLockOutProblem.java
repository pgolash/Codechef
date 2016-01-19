package Design.Synchronization;

/**
 * Created by prashantgolash on 09/01/16.
 */
public class NestedMonitorLockOutProblem {
    public class Lock{
        protected Object monitorObject = new Object();
        protected boolean isLocked = false;

        public void lock() throws InterruptedException{
            synchronized(this){
                while(isLocked){
                    synchronized(this.monitorObject){
                        this.monitorObject.wait();
                    }
                }
                isLocked = true;
            }
        }

        public void unlock(){
            synchronized(this){
                this.isLocked = false;
                synchronized(this.monitorObject){
                    this.monitorObject.notify();
                }
            }
        }
    }

}
