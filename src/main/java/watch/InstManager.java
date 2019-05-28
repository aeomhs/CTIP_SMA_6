package watch;

import java.util.ArrayList;

public class InstManager {

    private Timekeeping timekeeping;
    private Timer timer;

    private ArrayList<Alarm> alarmList;
    private int alarmIndex;
    private int alarmInstNum;

    private Stopwatch stopwatch;

    private ArrayList<Dday> dDayList;
    private int dDayIndex;
    private int dDayInstNum;

    private Fitness fitness;

    private SelectFunction selectFunction;

    private static InstManager ourInstance;

    public static InstManager getInstance() {
        if(ourInstance ==null)
            ourInstance = new InstManager();
        return ourInstance;
    }


    private InstManager() {
        alarmIndex = 0;
        dDayIndex = 0;

        alarmInstNum = 0;
        dDayInstNum = 0;

        timekeeping = new Timekeeping();
        timer = new Timer();
        alarmList = new ArrayList<Alarm>(4);
        stopwatch = new Stopwatch();
        dDayList = new ArrayList<Dday>(6);
        fitness = new Fitness();
        selectFunction = new SelectFunction();
    }
    // attribute getter, setter
    public int getAlarmIndex() {
        return alarmIndex;
    }

    public int getdDayIndex() {
        return dDayIndex;
    }

    public void setAlarmIndex(int alarmIndex) {
        this.alarmIndex = alarmIndex;
    }

    public void setdDayIndex(int dDayIndex) {
        this.dDayIndex = dDayIndex;
    }

    public int getAlarmInstNum() {
        alarmInstNum = alarmList.size();
        return alarmInstNum;
    }

    public int getdDayInstNum(){
        dDayInstNum = dDayList.size();
        return dDayInstNum;
    }

    // object getter
    public Timekeeping getTimekeeping() {
        return timekeeping;
    }

    public Timer getTimer() {
        return timer;
    }

    public Alarm getAlarm() {
        if(alarmList.size() == 0){
            return null;
        }
        else {
            return alarmList.get(alarmIndex);
        }
    }

    public Stopwatch getStopwatch() {
        return stopwatch;
    }

    public Dday getDday() {
        if(dDayList.size() == 0){
            return null;
        }
        else {
            return dDayList.get(dDayIndex);
        }
    }

    public Fitness getFitness() {
        return fitness;
    }

    public SelectFunction getSelectFunction() {
        return selectFunction;
    }

    public void deleteInst(String object){
        if(object.equals("alarm") == true){
            this.alarmList.remove(this.alarmIndex);
        }
        else if(object.equals("dDay")==true){
            this.dDayList.remove(this.dDayIndex);

        }
    }

    public Object createInst(String status){
        if(status.equals("alarm") == true) {//알람

            if(alarmList.size()<4){//알람 개수가 4개보다 적으면 추가
                Alarm alarm = new Alarm();
                alarmList.add(alarm);
                return alarm;
            }
            else{//이미 있는 알람 개수가 4개이상이면 생성하지 않음.
                return null;
            }
        }
        else if(status.equals("dDay") == true){//디데이
            if(dDayList.size()<6){ //목록이 6개보다 적다면
                Dday dDay = new Dday();
                dDayList.add(dDay);
                return dDay;
            }
            else{//이미 있는 목록 개수가 6개이상이면 생성하지 않음.
                return null;
            }
        }
        else{//알람과 디데이 이외의 상태일 때는 작업해주지 않음.
            return null;
        }
    }

}