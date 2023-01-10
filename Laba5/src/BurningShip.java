import java.awt.geom.Rectangle2D;
//Класс фрактала множества Мандельброта наследуемый от генератора фракталов
//Этот класс является подклассом FractalGenerator. Он используется для вычисления Фрактала
public class BurningShip extends FractalGenerator{
    private static final String NAME = "Burning Ship";
    //Константа с максимальным количеством итераций
    public static final int MAX_ITERATIONS = 2000;
    //Переопределение метода для получения исходного диапазона на определённое комп.число
    /**
     * Этот метод позволяет генератору фракталов указать, какая часть
     * комплексной плоскости наиболее интересен для фрактала.
     * Ему передается объект прямоугольника, и метод изменяет
     * поля прямоугольника, чтобы показать правильный начальный диапазон для фрактала.
     * Эта реализация устанавливает начальный диапазон в  x = -2, y = -1,5, width = height = 3.
     */
    @Override
    public void getInitialRange(Rectangle2D.Double range) {
        range.x = -2;
        range.y = -1.5;
        range.width = 3;
        range.height = 3;
    }
    //Переопределение метода для получения кол-ва итераций для текущей координаты
    /**
     * Этот метод реализует итерационную функцию для фрактала.
     * Требуется два числа double для действительной и мнимой частей комплекса
     * plane и возвращает количество итераций для соответствующей координаты.
     */
    @Override
    public int numIterations(double x, double y) {
        int iteration = 0;
        double zreal = 0;
        double zimaginary = 0;
        double zreal2 = 0;
        double zimaginary2 = 0;
        /**
         * Вычисляем,  значения представляют собой комплексные числа, представленные
         * по zreal и zimaginary, Z0 = 0, а c - особая точка в
         * фрактал, который мы показываем (заданный x и y). Это повторяется
         * до Z ^ 2> 4 (абсолютное значение Z больше 2) или максимум
         * достигнуто количество итераций.
         */
        while(iteration < MAX_ITERATIONS && (zimaginary2 + zreal2) < 4)
        {
            zimaginary = Math.abs((2 * zreal * zimaginary)) + y;
            zreal = (zreal2 - zimaginary2) + x;

            zreal2 = zreal*zreal;
            zimaginary2 = zimaginary*zimaginary;
            iteration++;
        }
        /**
         * Если количество максимальных итераций достигнуто, возвращаем -1, чтобы
         * указать, что точка не вышла за границу.
         */
        if (iteration == MAX_ITERATIONS) {
            return -1;
        }
        return iteration;
    }

    public String toString() {
        return "Burning Ship";
    }
}

