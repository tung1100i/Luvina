/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thread.Unknown;


public class RAMutex extends Process implements Lock {  
    int myts;
    LamportClock c = new LamportClock();
    IntLinkedList pendingQ = new IntLinkedList();
    int numOkay = 0;
    public RAMutex(Linker initComm) {
        super(initComm);
        myts = Symbols.Infinity;
    }
    @Override
    public synchronized void requestCS() {
        c.tick();
        myts = c.getValue();
        broadcastMsg("request", myts);
        numOkay = 0;
        while (numOkay < N-1)
            myWait(); 
    }
    @Override
    public synchronized void releaseCS() {
        myts = Symbols.Infinity;
        while (!pendingQ.isEmpty()) {
            int pid = pendingQ.removeHead();
            sendMsg(pid, "okay", c.getValue());
        }
    }
    @Override
    public synchronized void handleMsg(Msg m, int src, String tag) {
        int timeStamp = m.getMessageInt();
        c.receiveAction(src, timeStamp);
        if (tag.equals("request")) {
            if ((myts == Symbols.Infinity) // not interested in CS
                    || (timeStamp < myts)
                    || ((timeStamp == myts) && (src < myId)))
                sendMsg(src, "okay", c.getValue());
            else
                pendingQ.add(src);
        } else if (tag.equals("okay")) {
            numOkay++;
            if (numOkay == N - 1)
                notify(); // okayCS() may be true now
        }
    }
}
