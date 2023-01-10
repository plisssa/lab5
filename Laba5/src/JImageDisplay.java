import java.awt.image.BufferedImage;
import java.awt.*;

//Класс дисплея, наследуемый от JComponent
//Пользовательский интерфейс
//Класс JImageDisplay даст возможность нам отображать наши фракталы.
// Этот класс дисплея является производным от javax.swing.JComponent.
//объявлены, но не реализованы
public class JImageDisplay extends javax.swing.JComponent{
    /**
     * Экземпляр буферизованного изображения.
     * Управляет изображением, содержимое которого мы можем писать.
     */
    private BufferedImage buffImage;

    //Конструктор класса
    /**
     * Конструктор принимает целые значения ширины и высоты и инициализирует
     * его объект BufferedImage должен быть новым изображением с такой шириной и высотой
     * типа изображения TYPE_INT_RGB.
     * Тип определяет, как цвета каждого пикселя будут представлены в изображении;
     * значение TYPE_INT_RGB обозначает, что красные, зеленые и синие компоненты имеют по 8 битов,
     * представленные в формате int в указанном порядке.
     */
    public JImageDisplay(int width, int height) {
        buffImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        /**
         * Вызваем метод setPreferredSize() родительского класса
         * с заданной шириной и высотой.
         * Мы должны будем передать эти значения в объект java.awt.Dimension
         */
        Dimension dimension = new Dimension(width, height);
        super.setPreferredSize(dimension);
    }

    //Метод для отрисовки изображения
    /**
     * Реализация суперкласса paintComponent(g) вызывает так, что границы и
     * черты нарисованы правильно. Затем изображение втягивается в компонент.
     * Мы передаем значение null для ImageObserver, поскольку данная
     * функциональность не требуется.
     */
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage (buffImage, 0, 0, buffImage.getWidth(), buffImage.getHeight(), null);
    }

    //Оба следующих метода будут необходимы для использования в методе setRGB () класса BufferedImage.
    //Метод для очистки изображения
    /**
     * Устанавливает все пиксели в данных изображениях черными. (значение RGB 0)
     */
    public void clearImage() {
        int[] rgbArray = new int[buffImage.getWidth() * buffImage.getHeight()];
        buffImage.setRGB(0, 0, buffImage.getWidth(), buffImage.getHeight(), rgbArray, 0, 1);
    }

    //Метод для установки пикселя в определенный цвет
    public void drawPixel(int x, int y, int color){
        buffImage.setRGB(x, y, color);
    }
    /**
     * Устанавливает пиксель определенного цвета.
     * Данные из приватной переменной
     */
    public BufferedImage getImage(){
        return buffImage;
    }
}
