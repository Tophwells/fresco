/*******************************************************************************
 * Copyright (c) 2015 FRESCO (http://github.com/aicis/fresco).
 *
 * This file is part of the FRESCO project.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT.  IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 *
 * FRESCO uses SCAPI - http://crypto.biu.ac.il/SCAPI, Crypto++, Miracl, NTL,
 * and Bouncy Castle. Please see these projects for any further licensing issues.
 *******************************************************************************/
package dk.alexandra.fresco.suite.bgw.integer;

import dk.alexandra.fresco.framework.value.SInt;
import dk.alexandra.fresco.suite.bgw.ShamirShare;


/**
 * In this implementation a secure integer is an integer shared using shamir secret sharing.
 * 
 */
public class BgwSInt implements SInt {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5634025110628981708L;
	public ShamirShare value;
	
	public BgwSInt() {
		this.value = null;
	}
	
	public BgwSInt(ShamirShare val) {
		this.value = val;
	}
	
	@Override
	public String toString() {
		return "ShamirSInt(" + value + ")";
	}

	@Override
	public boolean isReady() {
		if (this.value == null) return false;
		return value.isReady();
	}

	@Override
	public byte[] getSerializableContent() {
		return this.value.toByteArray();
	}

	@Override
	public void setSerializableContent(byte[] val) {
		this.value = new ShamirShare(val);
	}
	
}
