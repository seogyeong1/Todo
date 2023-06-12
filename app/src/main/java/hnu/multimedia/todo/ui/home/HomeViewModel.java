package hnu.multimedia.todo.ui.home;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;

public class HomeViewModel extends ViewModel {

    private final MutableLiveData<ArrayList<TaskItem>> taskList;

    public HomeViewModel() {
        taskList = new MutableLiveData<>();
        ArrayList<TaskItem> _list = new ArrayList<>();

        for (int i = 0 ; i < 10 ; i ++) {
            _list.add(new TaskItem(String.valueOf(i)));
        }
        taskList.setValue(_list);
    }

    public LiveData<ArrayList<TaskItem>> getTaskList() {
        return taskList;
    }
}