package hnu.multimedia.todo.ui.team;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import hnu.multimedia.todo.R;
import hnu.multimedia.todo.databinding.TaskItemBinding;

public class TaskTeamAdapter extends RecyclerView.Adapter<TaskTeamAdapter.ViewHolder>{

    ArrayList<TaskTeamItem> list;
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

    void setTaskItemList(ArrayList<TaskTeamItem> list){
        this.list = list;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TaskItemBinding taskItemBinding;

        public ViewHolder(@NonNull View taskView) {
            super(taskView);
            taskItemBinding = TaskItemBinding.bind(taskView);

        }

        public void setTask(TaskTeamItem taskItem) {
            taskItemBinding.tvTodoTitle.setText(taskItem.getTask());
        }

    }
}