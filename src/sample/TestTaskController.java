package sample;

import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class TestTaskController {
    public Label resultLabel;
    public ComboBox taskBox;
    public TextField FirstField;
    public TextField SecondField;
    private String[] conditions = new String[2];

    public void Calculate(ActionEvent actionEvent) {
        conditions[0] = FirstField.getText();
        conditions[1] = SecondField.getText();
        switch ((String)taskBox.getValue()){
            case "Substring Task":              //если выбрана задача нахождения включений в строке
                if(conditions[0] != "" && conditions[1] != "")                          //проверка заполненых условий
                resultLabel.setText(Logic.findSubString(conditions));                   //вызов вычисления первого задания
                break;                                                                  //и помещение результата в ярлык

            case "Decimal Decomposition":       //если выбрана задача разложения числа на десятичные степени
                try{
                    if(conditions[0] != "") {
                        int currValue = (Integer.parseInt(conditions[0]));
                        if (currValue > 0)                                                      // убеждаемся, что чило больше нуля
                            resultLabel.setText(Logic.decompose(conditions));
                    }
                } catch (NumberFormatException e){
                    System.out.println("Число с дробной частью, либо смешанного содержания"); // отлов записи данных противоречащих условиям, возобновляем выполнение потока
                }
                break;

                default:
                break;
        }
    }

    public void Save(ActionEvent actionEvent) {
        Node node = (Node) actionEvent.getSource();     //в обоих случаях работы из файла обращаемся к узлу, из которого будет вызываться диалог выбора файла
        conditions = new String[2];
        conditions[0] = FirstField.getText();
        conditions[1] = SecondField.getText();
        TxtIO.saveData(node, conditions);       //передаем узел, из которого будет вызываться диалог выбора файла, и условия в метод сохранения данных в файл
    }

    public void Load(ActionEvent actionEvent) {
        Node node = (Node) actionEvent.getSource();
        conditions = TxtIO.loadData(node);      //передаем узел, из которого будет вызываться диалог выбора файла, в метод загрузки данных из файла
        FirstField.setText(conditions[0]);
        SecondField.setText(conditions[1]);
    }
}
