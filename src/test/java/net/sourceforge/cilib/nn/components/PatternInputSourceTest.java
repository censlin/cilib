/**
 * Copyright (C) 2003 - 2009
 * Computational Intelligence Research Group (CIRG@UP)
 * Department of Computer Science
 * University of Pretoria
 * South Africa
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
 */
package net.sourceforge.cilib.nn.components;

import net.sourceforge.cilib.io.pattern.StandardPattern;

import net.sourceforge.cilib.math.Maths;
import net.sourceforge.cilib.nn.architecture.NeuralInputSource;
import net.sourceforge.cilib.type.types.container.Vector;
import net.sourceforge.cilib.util.Vectors;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author andrich
 */
public class PatternInputSourceTest {

    private StandardPattern standardPattern;

    @Before
    public void setup() {
        Vector vector = Vectors.create(0.1, 0.2, 0.3, 0.4, 0.5);
        standardPattern = new StandardPattern(vector, vector);
    }

    @Test
    public void testGetNeuralInput() {
        NeuralInputSource source = new PatternInputSource(standardPattern);
        for (int i = 0; i < standardPattern.getVector().size(); i++) {
            Assert.assertEquals(standardPattern.getVector().getReal(i), source.getNeuralInput(i), Maths.EPSILON);
        }
    }
}