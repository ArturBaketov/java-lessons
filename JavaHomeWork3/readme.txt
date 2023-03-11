  1. Дан массив записей: наименование товара, цена, сорт. Найти наибольшую цену товаров 1го или 2го сорта среди товаров, название которых содержит «высший».
    2. Сведения о товаре состоят из наименования, страны-производителя, веса, цены, сорта. Получить наименования товаров заданного сорта с наименьшей ценой.
    3. Сведения о книге состоят из названия, фамилии автора, цены, года издания и количества страниц. Найти названия книг, в которых простое количество страниц, фамилия автора содержит «А» и год издания после 2010 г, включительно.
    4. при входном массиве, вернуть массив массивов со всеми перестановками его элементов. (со звездочкой)
    Пример входных данных:
    [1,2,3]
    Пример выходных данных:
    [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]public Items(String name) {
        this.name = name;
    }
    public Items() {
        this.name = "";
        this.price = 0.0;
        this.sort = 0;
    }

    public Items(String name, Double price, Integer sort) {
        this.name = name;
        this.price = price;
        this.sort = sort;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }
