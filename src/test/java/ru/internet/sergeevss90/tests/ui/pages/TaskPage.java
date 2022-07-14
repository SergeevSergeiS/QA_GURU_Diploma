package ru.internet.sergeevss90.tests.ui.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import ru.internet.sergeevss90.tests.ui.TestDataGenerator;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class TaskPage {

    TestDataGenerator generator = new TestDataGenerator();
    public SelenideElement
            tooltipToaster = $("[data-testid=toaster]"),
            newTaskButton = $("#quick_add_task_holder"),
            taskNameInput = $(".public-DraftEditor-content"),
            taskDescriptionInput = $(".task_editor__description_field"),
            priorityFlagsList = $(".item_actions_priority"),
            priorityFlag = $(byText("Priority " + generator.getPriority())),
            buttonAddTask = $(".a878a9a4 > ._09c23660");;


    public TaskPage startTaskCreation() {
        newTaskButton.click();
        return this;
    }

    public TaskPage inputTaskName() {
        taskNameInput.setValue(generator.getTaskName());
        return this;
    }

    public TaskPage inputTaskDescription() {
        taskDescriptionInput.setValue(generator.getTaskDescription());
        return this;
    }

    public TaskPage openPriorityFlag() {
        priorityFlagsList.click();
        return this;
    }

    public TaskPage setPriority() {
        priorityFlag.click();
        return this;
    }

    public TaskPage addNewTask() {
        buttonAddTask.click();
        return this;
    }

    public TaskPage checkTooltip() {
        tooltipToaster.shouldHave(Condition.text("Task added to Inbox"));
        return this;
    }
}
