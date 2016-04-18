package pl.edu.agh.ztis.client;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.chart.PieChart;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import org.apache.log4j.Logger;
import pl.edu.agh.ztis.client.charts.ChartType;
import pl.edu.agh.ztis.client.table.NotesTableTools;
import pl.edu.agh.ztis.entity.Language;
import pl.edu.agh.ztis.entity.Magazine;
import pl.edu.agh.ztis.entity.TaggedNote;

import java.net.URL;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

/**
 * Created by kkicinger on 16/04/16.
 */
public class ClientAppController implements Initializable {

    private static Logger LOGGER = Logger.getLogger(ClientAppController.class);

    @FXML private HBox chartBox;
    @FXML private TableView<TaggedNote> notesTableView;
    @FXML private Accordion optionsAccordion;

    @FXML private DatePicker beginDatePicker;
    @FXML private DatePicker endDatePicker;

    @FXML private CheckBox englishLanguageCheckBox;
    @FXML private CheckBox frenchLanguageCheckBox;
    @FXML private CheckBox spanishLanguageCheckBox;

    @FXML private TextArea titleKeywordsTextArea;
    @FXML private TextArea contentKeywordsTextArea;

    @FXML private ScrollPane magazinesScrollPane;
    @FXML private VBox magazinesVBox;

    @FXML private CheckBox ebolaFilterUsedCheckBox;
    @FXML private CheckBox ebolaConnectedCheckBox;

    @FXML private TextField chartTitleTextField;
    @FXML private TextField xAxisLabelTextField;
    @FXML private TextField yAxisLabelTextField;
    @FXML private ChoiceBox<ChartType> chartTypeChoiceBox;


    private List<CheckBox> magazineCheckboxes;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        initializeMagazinesScrollPane();
        initializeLanguageCheckBoxes();
        initializeOptionsAccordion();
        initializeEbolaFilters();
        initializeChartInformationSection();
        initializeNotesTableView();
    }

    //<editor-fold desc="Button Actions">
    @FXML
    public void clearAllFiltersAction(ActionEvent actionEvent) {
        beginDatePicker.setValue(null);
        endDatePicker.setValue(null);
        englishLanguageCheckBox.setSelected(true);
        frenchLanguageCheckBox.setSelected(true);
        spanishLanguageCheckBox.setSelected(true);
        titleKeywordsTextArea.setText(null);
        contentKeywordsTextArea.setText(null);
        ebolaFilterUsedCheckBox.setSelected(false);
    }

    @FXML
    public void clearAllChartInformationAction(ActionEvent actionEvent) {
        chartTitleTextField.setText(null);
        xAxisLabelTextField.setText(null);
        yAxisLabelTextField.setText(null);
        chartTypeChoiceBox.setValue(null);
    }

    @FXML
    public void filterDataAction() {
        LOGGER.info("Filter data action");
    }

    @FXML
    public void drawChartAction(ActionEvent actionEvent) {
        ObservableList<PieChart.Data> pieChartData =
                FXCollections.observableArrayList(
                        new PieChart.Data("Grapefruit", 13),
                        new PieChart.Data("Oranges", 25),
                        new PieChart.Data("Plums", 10),
                        new PieChart.Data("Pears", 22),
                        new PieChart.Data("Apples", 30));
        final PieChart chart = new PieChart(pieChartData);
        chart.setTitle(titleKeywordsTextArea.getText());
        chartBox.getChildren().clear();
        chartBox.getChildren().add(chart);
    }
    //</editor-fold>

    //<editor-fold desc="Chart Information Actions">
    @FXML
    public void onXAxisLabelChangeAction(ActionEvent actionEvent) {
        LOGGER.info("X axis changed: " + xAxisLabelTextField.getText());
    }

    @FXML
    public void onYAxisLabelChangeAction(ActionEvent actionEvent) {
        LOGGER.info("Y axis changed: " + xAxisLabelTextField.getText());
    }

    @FXML
    public void onChartTitleChangeAction(ActionEvent actionEvent) {
        LOGGER.info("Chart title changed: " + xAxisLabelTextField.getText());
    }
    //</editor-fold>

    //<editor-fold desc="Filters Action">
    @FXML
    public void onBeginDateChangeAction(ActionEvent actionEvent) {
        LocalDate date = beginDatePicker.getValue();
        LOGGER.info("Begin date: " + date);
    }

    @FXML
    public void onEndDateChangeAction(ActionEvent actionEvent) {
        LocalDate date = endDatePicker.getValue();
        LOGGER.info("End date: " + date);
    }

    @FXML
    public void onTitleKeywordsChangeAction(ActionEvent actionEvent) {
        LOGGER.info("Title keywords: " + titleKeywordsTextArea.getText());
    }

    @FXML
    public void onContentKeywordsChangeAction(ActionEvent actionEvent) {
        LOGGER.info("Content keywords: " + contentKeywordsTextArea.getText());
    }
    // </editor-fold >

    //<editor-fold desc="Initialization methods">
    private void initializeOptionsAccordion() {
        optionsAccordion.setExpandedPane(optionsAccordion.getPanes().get(0));
    }

    private void initializeLanguageCheckBoxes() {
        initializeLanguageCheckBox(englishLanguageCheckBox);
        initializeLanguageCheckBox(frenchLanguageCheckBox);
        initializeLanguageCheckBox(spanishLanguageCheckBox);
    }

    private void initializeLanguageCheckBox(CheckBox languageCheckBox) {
        languageCheckBox.setSelected(true);
        languageCheckBox.selectedProperty().addListener((observable, oldValue, newValue) -> {
            LOGGER.info("Language checkbox: " + languageCheckBox.getText() + " - " + newValue);
        });
    }

    private void initializeMagazinesScrollPane() {
        magazinesVBox.getChildren().addAll(initializeMagazinesChildren());
        magazinesScrollPane.setContent(magazinesVBox);
    }

    private void initializeEbolaFilters() {
        ebolaFilterUsedCheckBox.selectedProperty().addListener((observable, oldValue, newValue) -> {
            ebolaConnectedCheckBox.setDisable(!newValue);
        });
    }

    private void initializeChartInformationSection() {
        chartTypeChoiceBox.setItems(FXCollections.observableArrayList(Arrays.asList(ChartType.values())));
    }


    private List<Node> initializeMagazinesChildren() {
        return initializeMagazineCheckboxes().stream().map(this::convertToBox).collect(Collectors.toList());
    }

    private List<CheckBox> initializeMagazineCheckboxes() {
        magazineCheckboxes = getMagazines().stream().map(this::convertToCheckBox).collect(Collectors.toList());
        return magazineCheckboxes;
    }

    private CheckBox convertToCheckBox(Magazine magazine) {
        CheckBox checkBox = new CheckBox(magazine.name());
        checkBox.setSelected(true);
        checkBox.selectedProperty().addListener((observable, oldValue, newValue) -> {
            LOGGER.info("Checkbox: " + checkBox.getText() + " - " + newValue);
        });
        return checkBox;
    }

    private HBox convertToBox(CheckBox checkBox) {
        HBox box = new HBox();
        box.getChildren().add(checkBox);
        box.setMargin(checkBox, new Insets(5.0, 0.0, 5.0, 0.0));
        return box;
    }

    private List<Magazine> getMagazines() {
        return Arrays.asList(Magazine.values()).stream().sorted((v1, v2) -> v1.name().compareTo(v2.name())).collect(Collectors.toList());
    }

    private void initializeNotesTableView() {
        notesTableView.getColumns().addAll(
                NotesTableTools.createIdColumn(),
                NotesTableTools.createLanguageColumn(),
                NotesTableTools.createCountryColumn(),
                NotesTableTools.createMagazineColumn(),
                NotesTableTools.createTimeColumn(),
                NotesTableTools.createTitleColumn(),
                NotesTableTools.createContentColumn()
        );

        List<TaggedNote> notes = LongStream.range(1, 100).boxed().map(i -> {
            TaggedNote note = new TaggedNote();
            note.setId(i);
            note.setSourceId(i);
            note.setLanguage(Language.ENGLISH);
            note.setMagazine(Magazine.AUSTRA);
            note.setCountry("PL");
            note.setTime(new Date());
            note.setTitle("adfjaslfdj");
            note.setContent("sdljgjdflkdajfljajfdlasdjghahifsgiuhadsiofijasd;fjioajsdfja");
            return note;
        }).collect(Collectors.toList());

        notesTableView.setItems(FXCollections.observableArrayList(notes));
    }
    //</editor-fold>

}
