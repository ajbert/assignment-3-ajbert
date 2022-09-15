package edu.wctc;

import java.util.*;



    public class VennDiagram<T>{


        private String label1, label2, label3;
        Set<T> set1, set2, set3;


        public VennDiagram(String label1, String label2, String label3) {
            this.label1 = label1;
            this.label2 = label2;
            this.label3 = label3;
            set1 = new HashSet<T>();
            set2 = new HashSet<T>();
            set3 = new HashSet<T>();
        }

        public void add(T item, String... labels) {
            for (String label : labels) {
                getCircleForLabel(label).add(item);
            }

        }

        private Set<T> getCircleForLabel(String label) {
            if (label.equals(getLabel1()))
                return set1;
            else if (label.equals(getLabel2()))
                return set2;
            else if (label.equals(getLabel3()))
                return set3;
            else
                return null;

        }

        public Set<T> intersectionOf(String first, String second){
            Set<T> firstAndSecond = new HashSet<>(getCircleForLabel(first));
            firstAndSecond.retainAll(getCircleForLabel(second));
            return firstAndSecond;
        }

        public Set<T> complementOf(String first, String second){
            Set<T> firstButNotSecond = new HashSet<>(getCircleForLabel(first));
            firstButNotSecond.removeAll(getCircleForLabel(second));
            return firstButNotSecond;
        }

        public Set<T> unionOf(String first, String second){
            Set<T> firstOrSecond = new HashSet<>(getCircleForLabel(first));
            firstOrSecond.addAll(getCircleForLabel(second));
            return firstOrSecond;
        }

        public Set<T> diagramCenter(){
            Set<T> allThree = new HashSet<>(set1);
            allThree.retainAll(set2);
            allThree.retainAll(set3);
            return allThree;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            VennDiagram<?> that = (VennDiagram<?>) o;
            return label1.equals(that.label1) && label2.equals(that.label2) && label3.equals(that.label3);
        }

        @Override
        public int hashCode() {
            return Objects.hash(label1, label2, label3);
        }

        public String getLabel1() {
            return label1;
        }

        public String getLabel2() {
            return label2;
        }

        public String getLabel3() {
            return label3;
        }
    }


