/*
 * Copyright 2015-2018 the original author or authors.
 *
 * All rights reserved. This program and the accompanying materials are
 * made available under the terms of the Eclipse Public License v2.0 which
 * accompanies this distribution and is available at
 *
 * http://www.eclipse.org/legal/epl-v20.html
 */

package com.example.project.init;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Legacy {

	@Test
	public void adds_Two_Numbers() {
		assertThat(5).isEqualTo((2+3));
	}
}
