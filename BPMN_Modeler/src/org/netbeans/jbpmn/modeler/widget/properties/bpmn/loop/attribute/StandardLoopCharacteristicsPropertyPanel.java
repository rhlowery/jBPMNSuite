/**
 * Copyright [2014] Gaurav Gupta
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package org.netbeans.jbpmn.modeler.widget.properties.bpmn.loop.attribute;

import org.netbeans.jbpmn.modeler.specification.bpmn.util.BPMNModelUtil;
import org.netbeans.jbpmn.spec.TDefinitions;
import org.netbeans.jbpmn.spec.TFormalExpression;
import org.netbeans.jbpmn.spec.TItemDefinition;
import org.netbeans.jbpmn.spec.TStandardLoopCharacteristics;
import org.netbeans.jbpmn.spec.extend.LanguageManager;
import org.netbeans.modeler.core.NBModelerUtil;
import org.netbeans.modeler.core.ModelerFile;
import org.netbeans.modeler.properties.embedded.GenericEmbeddedEditor;
import org.netbeans.modeler.properties.entity.custom.editor.combobox.client.entity.ComboBoxValue;

public class StandardLoopCharacteristicsPropertyPanel extends GenericEmbeddedEditor<TStandardLoopCharacteristics> {

    TStandardLoopCharacteristics standardLoopCharacteristics;
    private ModelerFile modelerFile;
    private TDefinitions definition;

    private String actionPanelType;

    @Override
    public TStandardLoopCharacteristics getValue() {
        standardLoopCharacteristics.setLoopMaximum((Integer) loopMaximumComponent.getValue());
        standardLoopCharacteristics.setTestBefore(testBeforeComponent.isSelected());
        TFormalExpression condition = standardLoopCharacteristics.getLoopCondition();

        ComboBoxValue<String> language_comboBoxValue;
        if (language_ComboBox.getSelectedItem() instanceof String) {
            language_comboBoxValue = new ComboBoxValue<String>((String) language_ComboBox.getSelectedItem(), (String) language_ComboBox.getSelectedItem());
        } else {
            language_comboBoxValue = (ComboBoxValue<String>) language_ComboBox.getSelectedItem();
        }
        condition.setLanguage(language_comboBoxValue.getValue());
        condition.setContent(script_TextArea.getText().trim());
        condition.setEvaluatesToTypeRef(((ComboBoxValue<TItemDefinition>) evaluatesToType_ComboBox.getSelectedItem()).getId());
        return standardLoopCharacteristics;
    }

    @Override
    public void setValue(TStandardLoopCharacteristics standardLoopCharacteristics) {
        initScriptTypeComboBox();
        initEvaluatesToTypeComboBox();
        if (standardLoopCharacteristics == null) {
            standardLoopCharacteristics = new TStandardLoopCharacteristics();
            standardLoopCharacteristics.setId(NBModelerUtil.getAutoGeneratedStringId());
        }
        this.standardLoopCharacteristics = standardLoopCharacteristics;
        loopMaximumComponent.setValue(standardLoopCharacteristics.getLoopMaximum());
        testBeforeComponent.setSelected(standardLoopCharacteristics.isTestBefore());
        if (standardLoopCharacteristics.getLoopCondition() == null) {
            TFormalExpression condition = new TFormalExpression();
            condition.setId(NBModelerUtil.getAutoGeneratedStringId());
            standardLoopCharacteristics.setLoopCondition(condition);
        }
        TFormalExpression condition = standardLoopCharacteristics.getLoopCondition();
        language_ComboBox.setSelectedItem(LanguageManager.getLanguage(condition.getLanguage()));
        script_TextArea.setText(condition.getContent());
        for (int i = 0; i < evaluatesToType_ComboBox.getItemCount(); i++) {
            ComboBoxValue<TItemDefinition> itemDefinition = (ComboBoxValue<TItemDefinition>) evaluatesToType_ComboBox.getItemAt(i);
            if (itemDefinition.getValue() != null && itemDefinition.getValue().getId().equals(condition.getEvaluatesToTypeRef())) {//BUG : remove row[4] use object
                evaluatesToType_ComboBox.setSelectedItem(itemDefinition);
                break;
            }
        }

    }

    @Override
    public void init() {
        initComponents();
        language_ComboBox.setEditable(true);
    }

    /**
     * Creates new form LoopCharacteristicsPropertyPanel
     */
    public StandardLoopCharacteristicsPropertyPanel(ModelerFile modelerFile) {
        this.modelerFile = modelerFile;
        definition = (TDefinitions) modelerFile.getDefinitionElement();
    }

    private void initScriptTypeComboBox() {
        language_ComboBox.removeAllItems();
        for (ComboBoxValue<String> language : LanguageManager.getLanguageList()) {
            language_ComboBox.addItem(language);
        }
        language_ComboBox.setSelectedItem(LanguageManager.getLanguage(null));
    }

    private void initEvaluatesToTypeComboBox() {
        evaluatesToType_ComboBox.removeAllItems();
        for (ComboBoxValue<TItemDefinition> itemDefinition : BPMNModelUtil.getItemDefinitionList(modelerFile)) {
            evaluatesToType_ComboBox.addItem(itemDefinition);
        }
        evaluatesToType_ComboBox.setSelectedItem(new ComboBoxValue<TItemDefinition>(null, null, ""));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFrame1 = new javax.swing.JFrame();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        testBefore_LayeredPane = new javax.swing.JLayeredPane();
        testBeforeLabel = new javax.swing.JLabel();
        testBeforeComponent = new javax.swing.JCheckBox();
        loopMaximum_LayeredPane = new javax.swing.JLayeredPane();
        loopMaximumLabel = new javax.swing.JLabel();
        loopMaximumComponent = new javax.swing.JSpinner();
        expression_LayeredPane = new javax.swing.JLayeredPane();
        language_LayeredPane = new javax.swing.JLayeredPane();
        language_Label = new javax.swing.JLabel();
        language_ComboBox = new javax.swing.JComboBox();
        script_LayeredPane = new javax.swing.JLayeredPane();
        script_Label = new javax.swing.JLabel();
        script_ScrollPane = new javax.swing.JScrollPane();
        script_TextArea = new javax.swing.JTextArea();
        evaluateType_LayeredPane = new javax.swing.JLayeredPane();
        evaluatesToType_Label = new javax.swing.JLabel();
        evaluatesToType_ComboBox = new javax.swing.JComboBox();
        evaluatesToType_Action = new javax.swing.JButton();

        javax.swing.GroupLayout jFrame1Layout = new javax.swing.GroupLayout(jFrame1.getContentPane());
        jFrame1.getContentPane().setLayout(jFrame1Layout);
        jFrame1Layout.setHorizontalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame1Layout.setVerticalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setMaximumSize(new java.awt.Dimension(255, 189));

        org.openide.awt.Mnemonics.setLocalizedText(testBeforeLabel, org.openide.util.NbBundle.getMessage(StandardLoopCharacteristicsPropertyPanel.class, "StandardLoopCharacteristicsPropertyPanel.testBeforeLabel.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(testBeforeComponent, org.openide.util.NbBundle.getMessage(StandardLoopCharacteristicsPropertyPanel.class, "StandardLoopCharacteristicsPropertyPanel.testBeforeComponent.text")); // NOI18N
        testBeforeComponent.setAlignmentX(0.5F);

        javax.swing.GroupLayout testBefore_LayeredPaneLayout = new javax.swing.GroupLayout(testBefore_LayeredPane);
        testBefore_LayeredPane.setLayout(testBefore_LayeredPaneLayout);
        testBefore_LayeredPaneLayout.setHorizontalGroup(
            testBefore_LayeredPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(testBefore_LayeredPaneLayout.createSequentialGroup()
                .addComponent(testBeforeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addComponent(testBeforeComponent, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        testBefore_LayeredPaneLayout.setVerticalGroup(
            testBefore_LayeredPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(testBeforeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(testBeforeComponent, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        testBefore_LayeredPane.setLayer(testBeforeLabel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        testBefore_LayeredPane.setLayer(testBeforeComponent, javax.swing.JLayeredPane.DEFAULT_LAYER);

        org.openide.awt.Mnemonics.setLocalizedText(loopMaximumLabel, org.openide.util.NbBundle.getMessage(StandardLoopCharacteristicsPropertyPanel.class, "StandardLoopCharacteristicsPropertyPanel.loopMaximumLabel.text")); // NOI18N

        javax.swing.GroupLayout loopMaximum_LayeredPaneLayout = new javax.swing.GroupLayout(loopMaximum_LayeredPane);
        loopMaximum_LayeredPane.setLayout(loopMaximum_LayeredPaneLayout);
        loopMaximum_LayeredPaneLayout.setHorizontalGroup(
            loopMaximum_LayeredPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(loopMaximum_LayeredPaneLayout.createSequentialGroup()
                .addComponent(loopMaximumLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(loopMaximumComponent, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );
        loopMaximum_LayeredPaneLayout.setVerticalGroup(
            loopMaximum_LayeredPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(loopMaximum_LayeredPaneLayout.createSequentialGroup()
                .addGroup(loopMaximum_LayeredPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(loopMaximumLabel)
                    .addComponent(loopMaximumComponent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(3, 3, 3))
        );
        loopMaximum_LayeredPane.setLayer(loopMaximumLabel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        loopMaximum_LayeredPane.setLayer(loopMaximumComponent, javax.swing.JLayeredPane.DEFAULT_LAYER);

        expression_LayeredPane.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), org.openide.util.NbBundle.getMessage(StandardLoopCharacteristicsPropertyPanel.class, "StandardLoopCharacteristicsPropertyPanel.expression_LayeredPane.border.title"), javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12), new java.awt.Color(102, 102, 102))); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(language_Label, org.openide.util.NbBundle.getMessage(StandardLoopCharacteristicsPropertyPanel.class, "StandardLoopCharacteristicsPropertyPanel.language_Label.text")); // NOI18N
        language_Label.setToolTipText(org.openide.util.NbBundle.getMessage(StandardLoopCharacteristicsPropertyPanel.class, "StandardLoopCharacteristicsPropertyPanel.language_Label.toolTipText")); // NOI18N

        javax.swing.GroupLayout language_LayeredPaneLayout = new javax.swing.GroupLayout(language_LayeredPane);
        language_LayeredPane.setLayout(language_LayeredPaneLayout);
        language_LayeredPaneLayout.setHorizontalGroup(
            language_LayeredPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(language_LayeredPaneLayout.createSequentialGroup()
                .addComponent(language_Label, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(language_ComboBox, 0, 341, Short.MAX_VALUE))
        );
        language_LayeredPaneLayout.setVerticalGroup(
            language_LayeredPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(language_LayeredPaneLayout.createSequentialGroup()
                .addGroup(language_LayeredPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(language_Label)
                    .addComponent(language_ComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 13, Short.MAX_VALUE))
        );
        language_LayeredPane.setLayer(language_Label, javax.swing.JLayeredPane.DEFAULT_LAYER);
        language_LayeredPane.setLayer(language_ComboBox, javax.swing.JLayeredPane.DEFAULT_LAYER);

        org.openide.awt.Mnemonics.setLocalizedText(script_Label, org.openide.util.NbBundle.getMessage(StandardLoopCharacteristicsPropertyPanel.class, "StandardLoopCharacteristicsPropertyPanel.script_Label.text")); // NOI18N
        script_Label.setToolTipText(org.openide.util.NbBundle.getMessage(StandardLoopCharacteristicsPropertyPanel.class, "StandardLoopCharacteristicsPropertyPanel.script_Label.toolTipText")); // NOI18N

        script_TextArea.setColumns(20);
        script_TextArea.setRows(5);
        script_ScrollPane.setViewportView(script_TextArea);

        javax.swing.GroupLayout script_LayeredPaneLayout = new javax.swing.GroupLayout(script_LayeredPane);
        script_LayeredPane.setLayout(script_LayeredPaneLayout);
        script_LayeredPaneLayout.setHorizontalGroup(
            script_LayeredPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(script_LayeredPaneLayout.createSequentialGroup()
                .addComponent(script_Label, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(script_ScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 342, Short.MAX_VALUE))
        );
        script_LayeredPaneLayout.setVerticalGroup(
            script_LayeredPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(script_LayeredPaneLayout.createSequentialGroup()
                .addComponent(script_Label)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(script_LayeredPaneLayout.createSequentialGroup()
                .addComponent(script_ScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE)
                .addGap(10, 10, 10))
        );
        script_LayeredPane.setLayer(script_Label, javax.swing.JLayeredPane.DEFAULT_LAYER);
        script_LayeredPane.setLayer(script_ScrollPane, javax.swing.JLayeredPane.DEFAULT_LAYER);

        org.openide.awt.Mnemonics.setLocalizedText(evaluatesToType_Label, org.openide.util.NbBundle.getMessage(StandardLoopCharacteristicsPropertyPanel.class, "StandardLoopCharacteristicsPropertyPanel.evaluatesToType_Label.text")); // NOI18N

        evaluatesToType_Action.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/netbeans/jbpmn/modeler/widget/properties/operation/settings.png"))); // NOI18N
        evaluatesToType_Action.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                evaluatesToType_ActionMousePressed(evt);
            }
        });

        javax.swing.GroupLayout evaluateType_LayeredPaneLayout = new javax.swing.GroupLayout(evaluateType_LayeredPane);
        evaluateType_LayeredPane.setLayout(evaluateType_LayeredPaneLayout);
        evaluateType_LayeredPaneLayout.setHorizontalGroup(
            evaluateType_LayeredPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(evaluateType_LayeredPaneLayout.createSequentialGroup()
                .addComponent(evaluatesToType_Label, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(evaluatesToType_ComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 334, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(evaluatesToType_Action, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 20, Short.MAX_VALUE))
        );
        evaluateType_LayeredPaneLayout.setVerticalGroup(
            evaluateType_LayeredPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(evaluateType_LayeredPaneLayout.createSequentialGroup()
                .addGroup(evaluateType_LayeredPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(evaluateType_LayeredPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(evaluatesToType_Label)
                        .addComponent(evaluatesToType_ComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(evaluatesToType_Action))
                .addGap(0, 14, Short.MAX_VALUE))
        );
        evaluateType_LayeredPane.setLayer(evaluatesToType_Label, javax.swing.JLayeredPane.DEFAULT_LAYER);
        evaluateType_LayeredPane.setLayer(evaluatesToType_ComboBox, javax.swing.JLayeredPane.DEFAULT_LAYER);
        evaluateType_LayeredPane.setLayer(evaluatesToType_Action, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout expression_LayeredPaneLayout = new javax.swing.GroupLayout(expression_LayeredPane);
        expression_LayeredPane.setLayout(expression_LayeredPaneLayout);
        expression_LayeredPaneLayout.setHorizontalGroup(
            expression_LayeredPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(expression_LayeredPaneLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(expression_LayeredPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(evaluateType_LayeredPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(script_LayeredPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(language_LayeredPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        expression_LayeredPaneLayout.setVerticalGroup(
            expression_LayeredPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, expression_LayeredPaneLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(language_LayeredPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(script_LayeredPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                .addComponent(evaluateType_LayeredPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        expression_LayeredPane.setLayer(language_LayeredPane, javax.swing.JLayeredPane.DEFAULT_LAYER);
        expression_LayeredPane.setLayer(script_LayeredPane, javax.swing.JLayeredPane.DEFAULT_LAYER);
        expression_LayeredPane.setLayer(evaluateType_LayeredPane, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(expression_LayeredPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jLayeredPane1Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(testBefore_LayeredPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(loopMaximum_LayeredPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(testBefore_LayeredPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(loopMaximum_LayeredPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(expression_LayeredPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jLayeredPane1.setLayer(testBefore_LayeredPane, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(loopMaximum_LayeredPane, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(expression_LayeredPane, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane1)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void evaluatesToType_ActionMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_evaluatesToType_ActionMousePressed
        actionPanelType = "evaluatesToType";
//        setting_PopupMenu.show(evt.getComponent(), evt.getX(), evt.getY());
    }//GEN-LAST:event_evaluatesToType_ActionMousePressed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLayeredPane evaluateType_LayeredPane;
    private javax.swing.JButton evaluatesToType_Action;
    private javax.swing.JComboBox evaluatesToType_ComboBox;
    protected javax.swing.JLabel evaluatesToType_Label;
    private javax.swing.JLayeredPane expression_LayeredPane;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JComboBox language_ComboBox;
    protected javax.swing.JLabel language_Label;
    private javax.swing.JLayeredPane language_LayeredPane;
    private javax.swing.JSpinner loopMaximumComponent;
    private javax.swing.JLabel loopMaximumLabel;
    private javax.swing.JLayeredPane loopMaximum_LayeredPane;
    protected javax.swing.JLabel script_Label;
    private javax.swing.JLayeredPane script_LayeredPane;
    private javax.swing.JScrollPane script_ScrollPane;
    private javax.swing.JTextArea script_TextArea;
    private javax.swing.JCheckBox testBeforeComponent;
    private javax.swing.JLabel testBeforeLabel;
    private javax.swing.JLayeredPane testBefore_LayeredPane;
    // End of variables declaration//GEN-END:variables

}
