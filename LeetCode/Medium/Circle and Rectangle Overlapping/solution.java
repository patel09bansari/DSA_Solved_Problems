class Solution {
    public boolean checkOverlap(int radius, int xCenter, int yCenter, int x1, int y1, int x2, int y2) {
        // Find the closest x-coordinate on/inside the rectangle to xCenter
        int nearestX = Math.max(x1, Math.min(xCenter, x2));
        
        // Find the closest y-coordinate on/inside the rectangle to yCenter
        int nearestY = Math.max(y1, Math.min(yCenter, y2));
        
        // Calculate the squared distance between the circle's center and the nearest point
        int dx = xCenter - nearestX;
        int dy = yCenter - nearestY;
        int squaredDistance = dx * dx + dy * dy;
        
        // Return true if the distance is within the radius
        return squaredDistance <= radius * radius;
    }
}