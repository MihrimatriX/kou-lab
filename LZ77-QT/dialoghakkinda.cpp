#include "dialoghakkinda.h"
#include "ui_dialoghakkinda.h"
#include <QMessageBox>

DialogHakkinda::DialogHakkinda(QWidget *parent) : QDialog(parent), ui(new Ui::DialogHakkinda)
{
    ui->setupUi(this);
}

DialogHakkinda::~DialogHakkinda()
{
    delete ui;
}

void DialogHakkinda::on_pushButton_clicked()
{
    //setModal(false);
}
