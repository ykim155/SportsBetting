package src;

import javax.swing.*;
import java.awt.*;

class RoundedPanel extends JPanel
    {
        private Color backgroundColor;
        private int cornerRadius = 15;
        private Color borderColor;

        public RoundedPanel(LayoutManager layout, int radius) {
            super(layout);
            borderColor = getForeground();
            cornerRadius = radius;
        }

        public RoundedPanel(LayoutManager layout, int radius, Color bgColor) {
            super(layout);
            borderColor = getForeground();
            cornerRadius = radius;
            backgroundColor = bgColor;
        }

        public RoundedPanel(int radius) {
            super();
            borderColor = getForeground();
            cornerRadius = radius;
        }

        public RoundedPanel(int radius, Color bgColor) {
            super();
            borderColor = getForeground();
            cornerRadius = radius;
            backgroundColor = bgColor;
        }

        // Added border color as a parameter.
        public RoundedPanel(int radius, Color bgColor, Color bdrColor) {
            super();
            borderColor = bdrColor;
            cornerRadius = radius;
            backgroundColor = bgColor;
        }

        // Added border color as a parameter.
        public RoundedPanel(LayoutManager layout, int radius, Color bgColor, Color bdrColor) {
            super(layout);
            borderColor = bdrColor;
            cornerRadius = radius;
            backgroundColor = bgColor;
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Dimension arcs = new Dimension(cornerRadius, cornerRadius);
            int width = getWidth();
            int height = getHeight();
            Graphics2D graphics = (Graphics2D) g;
            graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

            //Draws the rounded panel with borders.
            if (backgroundColor != null) {
                graphics.setColor(backgroundColor);
            } else {
                graphics.setColor(getBackground());
            }
            graphics.fillRoundRect(0, 0, width-1, height-1, arcs.width, arcs.height); //paint background
            graphics.setColor(borderColor);
            graphics.drawRoundRect(0, 0, width-1, height-1, arcs.width, arcs.height); //paint border
        }
    }
