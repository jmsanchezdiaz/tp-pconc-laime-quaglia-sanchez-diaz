import tasks.Task;

public class Buffer {
        private int size;
        private int start = 0;
        private final Task[] data;
        private int end = 0;

        public Buffer(int size){
            this.size = size;
            this.data = new Task[this.size + 1];;
        }

        public synchronized void produce(Task value) {
            while(isFull()){
                try{ wait(); } catch (InterruptedException e) {return;}
            }
            data[end] = value;
            end = next(end);
            notifyAll();
        }

        public synchronized Task consume() {
            while(isEmpty()) {
                try{ wait(); } catch (InterruptedException e) { return new Task(); } // TODO: ver que devolver :D
            }
            Task temp = data[start];
            data[start] = null;
            start = next(start);

            notifyAll();
            return temp;
        }

        private int next(int i) {
            return (i+1) % (size+1);
        }

        private boolean isFull() {
            return next(end) == start;
        }

        private boolean isEmpty() {
            return end == start;
        }
}
