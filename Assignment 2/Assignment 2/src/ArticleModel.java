    /**
     * The ArticleModel is a model class build with purpose to retrieve the file contents through various
     * setter and getter methods.
     *
     * @author Harshkumar N. Patel
     * @author Chirag H. Patel
     */

    public class ArticleModel {

        public String authors;
        public String journal;
        public String title;
        public String year;
        public String volume;
        public String number;
        public String pages;
        public String keywords;
        public String ISSN;
        public String month;
        public String doi;
        public boolean isValid;

        public ArticleModel() {
            this.authors = "";
            this.journal = "";
            this.title = "";
            this.year = "";
            this.volume = "";
            this.number = "";
            this.pages = "";
            this.keywords = "";
            this.doi = "";
            this.ISSN = "";
            this.month = "";
        }

        /**
         * @param authors  value of authors field
         * @param journal  value of journal field
         * @param title    value of title field
         * @param year     value of year field
         * @param volume   value of volume field
         * @param number   value of number field
         * @param pages    value of pages field
         * @param keywords value of keywords field
         * @param doi      value of doi field
         * @param ISSN     value of ISSN field
         * @param month    value of month field
         */
        public ArticleModel(String authors, String journal, String title, String year, String volume,
                            String number, String pages, String keywords, String doi, String ISSN, String month) {

            //this.id = id;
            this.authors = authors;
            this.journal = journal;
            this.title = title;
            this.year = year;
            this.volume = volume;
            this.number = number;
            this.pages = pages;
            this.keywords = keywords;
            this.doi = doi;
            this.ISSN = ISSN;
            this.month = month;

        }

        /**
         * To get author name
         *
         * @return will return the author name
         */
        public String getAuthor() {
            return authors;
        }

        /**
         * To get journal name
         *
         * @return will return journal name
         */
        public String getJournal() {
            return journal;
        }

        /**
         * To get Title of the article
         *
         * @return will return title of the article
         */
        public String getTitle() {
            return title;
        }

        /**
         * To get value of year
         *
         * @return will return value of year
         */
        public String getYear() {
            return year;
        }

        /**
         * To get value of volume
         *
         * @return will return value of volume
         */
        public String getVolume() {
            return volume;
        }

        /**
         * To get value of number
         *
         * @return will return value of number
         */
        public String getNumber() {
            return number;
        }

        /**
         * To get value of pages
         *
         * @return will return value of pages
         */
        public String getPages() {
            return pages;
        }

        /**
         * To get value of keyword
         *
         * @return will return value of keyword
         */
        public String getKeywords() {
            return keywords;
        }

        /**
         * To get value of DOI
         *
         * @return will return value of DOI
         */
        public String getDoi() {
            return doi;
        }

        /**
         * To get value of ISSN
         *
         * @return will return value of ISSN
         */
        public String getISSN() {
            return ISSN;
        }

        /**
         * To get value of Month
         *
         * @return will return value of Month
         */
        public String getMonth() {
            return month;
        }


        /**
         * To set author name
         *
         * @param authors will set author name
         */
        public void setAuthor(String authors) {
            this.authors = authors;
        }

        /**
         * To set journal name
         *
         * @param journal will set journal name
         */
        public void setJournal(String journal) {
            this.journal = journal;
        }

        /**
         * To set Title of the article
         *
         * @param title will set title of the article
         */
        public void setTitle(String title) {
            this.title = title;
        }

        /**
         * To set value of year
         *
         * @param year will set value of year
         */
        public void setYear(String year) {
            this.year = year;
        }

        /**
         * To set value of volume
         *
         * @param volume will set value of volume
         */
        public void setVolume(String volume) {
            this.volume = volume;
        }

        /**
         * To set value of number
         *
         * @param number will set value of number
         */
        public void setNumber(String number) {
            this.number = number;
        }

        /**
         * To set value of pages
         *
         * @param pages will set value of pages
         */
        public void setPages(String pages) {
            this.pages = pages;
        }

        /**
         * To set value of keyword
         *
         * @param keywords will set value of keyword
         */
        public void setKeywords(String keywords) {
            this.keywords = keywords;
        }

        /**
         * To set value of DOI
         *
         * @param doi will set value of DOI
         */
        public void setDoi(String doi) {
            this.doi = doi;
        }

        /**
         * To set value of ISSN
         *
         * @param ISSN will set value of ISSN
         */
        public void setISSN(String ISSN) {
            this.ISSN = ISSN;
        }

        /**
         * To set value of Month
         *
         * @param month will set value of Month
         */
        public void setMonth(String month) {
            this.month = month;
        }

        public void setData(String field, String data) {
            switch (field) {
                case "author": {
                    setAuthor(data);
                    break;
                }

                case "journal": {
                    setJournal(data);
                    break;
                }

                case "title": {
                    setTitle(data);
                    break;
                }

                case "year": {
                    setYear(data);
                    break;
                }

                case "volume": {
                    setVolume(data);
                    break;
                }

                case "number": {
                    setNumber(data);
                    break;
                }

                case "pages": {
                    setPages(data);
                    break;
                }

                case "keywords": {
                    setKeywords(data);
                    break;
                }

                case "doi": {
                    setDoi(data);
                    break;
                }

                case "ISSN": {
                    setISSN(data);
                    break;
                }

                case "month": {
                    setMonth(data);
                    break;
                }

                default: {
                    System.out.println("Wrong field name: " + field);
                }
            }

        }
        

    }
