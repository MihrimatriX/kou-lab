#ifndef DIALOGHAKKINDA_H
#define DIALOGHAKKINDA_H

#include <QDialog>

namespace Ui {
class DialogHakkinda;
}

class DialogHakkinda : public QDialog
{
    Q_OBJECT

public:
    explicit DialogHakkinda(QWidget *parent = nullptr);
    ~DialogHakkinda();

private slots:
    void on_pushButton_clicked();

private:
    Ui::DialogHakkinda *ui;
};

#endif // DIALOGHAKKINDA_H
