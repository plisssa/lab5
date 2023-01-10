import java.awt.geom.Rectangle2D;
//Создание фракталов
//Класс FractalGenerator предоставляет общий интерфейс и операции для генераторов фракталов,
// которые можно просмотреть в FractalExplorer.
//Данный файл предоставляет также некоторые полезные операции для перевода
// из экранных координат в систему координат вычисляемого фрактала.

/**
 * Этот класс предоставляет общий интерфейс и операции для фракталов.
 * генераторы, которые можно просмотреть в Fractal Explorer.
 */
public abstract class FractalGenerator {

    /**
     * Эта статическая вспомогательная функция принимает целочисленную координату и преобразует ее
     * в значение двойной точности, соответствующее определенному диапазону. это
     * используется для преобразования координат пикселей в значения двойной точности для
     * вычисление фракталов и др.
     *
     * @param rangeMin минимальное значение диапазона с плавающей запятой
     * @param rangeMax максимальное значение диапазона с плавающей запятой
     *
     * @param size размер измерения, из которого берутся координаты в пикселях.
     * Например, это может быть ширина или высота изображения.
     *
     * @param coord координата, для которой вычисляется значение двойной точности.
     * Координата должна находиться в диапазоне [0, размер].
     */
    public static double getCoord(double rangeMin, double rangeMax,
                                  int size, int coord) {

        assert size > 0;
        assert coord >= 0 && coord < size;

        double range = rangeMax - rangeMin;
        return rangeMin + (range * (double) coord / (double) size);
    }


    /**
     * Устанавливает указанный прямоугольник, чтобы он содержал начальный диапазон, подходящий для
     * генерируемый фрактал.
     */
    public abstract void getInitialRange(Rectangle2D.Double range);


    /**
     * Обновляет текущий диапазон, чтобы центрировать его по указанным координатам,
     * и для увеличения или уменьшения масштаба в соответствии с указанным коэффициентом масштабирования.
     */
    public void recenterAndZoomRange(Rectangle2D.Double range,
                                     double centerX, double centerY, double scale) {

        double newWidth = range.width * scale;
        double newHeight = range.height * scale;

        range.x = centerX - newWidth / 2;
        range.y = centerY - newHeight / 2;
        range.width = newWidth;
        range.height = newHeight;
    }


    /**
     * Учитывая координату <em>x</em> + <em>iy</em> на комплексной плоскости,
     * вычисляет и возвращает количество итераций до фрактала
     * функция выходит за пределы ограничивающей области для этой точки. Точка, которая
     * не исчезает до достижения предела итераций.
     * с результатом -1.
     */
    public abstract int numIterations(double x, double y);
}

