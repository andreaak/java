package _04_Other.workerThread;

public interface Queue{
    void put(RunnableTask r);
    RunnableTask take();
}