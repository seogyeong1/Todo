package hnu.multimedia.todo.ui.home;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import hnu.multimedia.todo.R;
import hnu.multimedia.todo.databinding.TaskItemBinding;

public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.ViewHolder>{

    ArrayList<TaskItem> list;
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.task_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.setTask(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void setTaskItemList(ArrayList<TaskItem> list){
        this.list = list;
        notifyDataSetChanged();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        private TaskItemBinding TaskItem;

        public ViewHolder(@NonNull View taskView) {
            super(taskView);
            TaskItem = TaskItemBinding.bind(taskView);

        }

        public void setTask(hnu.multimedia.todo.ui.home.TaskItem taskItem) {
            TaskItem.tvTodoTitle.setText(taskItem.getTask());
        }

    }
}